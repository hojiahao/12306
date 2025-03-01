package cn.edu.szu.train.business.service;

import cn.edu.szu.train.business.domain.*;
import cn.edu.szu.train.business.dto.ConfirmOrderMQDto;
import cn.edu.szu.train.business.enums.ConfirmOrderStatusEnum;
import cn.edu.szu.train.business.enums.RocketMQTopicEnum;
import cn.edu.szu.train.business.enums.SeatColEnum;
import cn.edu.szu.train.business.enums.SeatTypeEnum;
import cn.edu.szu.train.business.mapper.ConfirmOrderMapper;
import cn.edu.szu.train.business.request.ConfirmOrderDoRequest;
import cn.edu.szu.train.business.request.ConfirmOrderQueryRequest;
import cn.edu.szu.train.business.request.ConfirmOrderTicketRequest;
import cn.edu.szu.train.business.response.ConfirmOrderQueryResponse;
import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.exception.BusinessException;
import cn.edu.szu.train.common.exception.BusinessExceptionEnum;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.cloud.client.discovery.ReactiveDiscoveryClient.LOG;

@Service
public class BeforeConfirmOrderService {
    private static final Logger LOG = LoggerFactory.getLogger(BeforeConfirmOrderService.class);

    @Resource
    private ConfirmOrderMapper confirmOrderMapper;

    @Resource
    private SkTokenService skTokenService;

    @Resource
    private ConfirmOrderService confirmOrderService;

//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;

    @SentinelResource(value = "beforeDoConfirm", blockHandler = "beforeDoConfirmBlock")
    public Long beforeDoConfirm(ConfirmOrderDoRequest req) {
        Long id = null;
        // 根据前端传值，加入排队人数
        for (int i = 0; i < req.getLineNumber() + 1; ++i) {
            req.setMemberId(LoginMemberContext.getId());
            // 校验令牌余量
            boolean validSkToken = skTokenService.validSkToken(req.getDate(), req.getTrainCode(), LoginMemberContext.getId());
            if (validSkToken) {
                LOG.info("令牌校验通过！");
            } else {
                LOG.info("令牌校验不通过！");
                throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_SK_TOKEN_FAIL);
            }

            Date date = req.getDate();
            String trainCode = req.getTrainCode();
            String departure = req.getDeparture();
            String destination = req.getDestination();
            List<ConfirmOrderTicketRequest> tickets = req.getTickets();
            // 保存确认订单表，状态初始
            DateTime now = DateTime.now();
            ConfirmOrder confirmOrder = new ConfirmOrder();
            confirmOrder.setId(SnowUtil.getSnowflakeNextId());
            confirmOrder.setMemberId(LoginMemberContext.getId());
            confirmOrder.setDate(date);
            confirmOrder.setTrainCode(trainCode);
            confirmOrder.setDeparture(departure);
            confirmOrder.setDestination(destination);
            confirmOrder.setDailyTrainTicketId(req.getDailyTrainTicketId());
            confirmOrder.setStatus(ConfirmOrderStatusEnum.INIT.getCode());
            confirmOrder.setTickets(JSON.toJSONString(tickets));
            confirmOrder.setCreateTime(now);
            confirmOrder.setUpdateTime(now);
            confirmOrderMapper.insert(confirmOrder);

            // 发送
            ConfirmOrderMQDto confirmOrderMQDto = new ConfirmOrderMQDto();
            confirmOrderMQDto.setDate(req.getDate());
            confirmOrderMQDto.setTrainCode(req.getTrainCode());
            confirmOrderMQDto.setLogId(MDC.get("LOG_ID"));
//            String requestJson = JSON.toJSONString(confirmOrderMQDto);
//            LOG.info("排队购票，发送mq开始，消息：{}", requestJson);
//            rocketMQTemplate.convertAndSend(RocketMQTopicEnum.CONFIRM_ORDER.getCode(), requestJson);
//            LOG.info("排队购票，发送mq结束");
            confirmOrderService.doConfirm(confirmOrderMQDto);
            id = confirmOrder.getId();
        }
        return id;
    }

    /**
     * 降级方法，需包含限流方法的所有参数和BlockException参数
     *
     * @param req
     * @param e
     */
    public void beforeDoConfirmBlock(ConfirmOrderDoRequest req, BlockException e) {
        LOG.info("购票请求被限流：{}", req);
        throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_FLOW_EXCEPTION);
    }
}
