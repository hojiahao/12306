package cn.edu.szu.train.business.service;

import cn.edu.szu.train.business.domain.*;
import cn.edu.szu.train.business.enums.ConfirmOrderStatusEnum;
import cn.edu.szu.train.business.enums.SeatColEnum;
import cn.edu.szu.train.business.enums.SeatTypeEnum;
import cn.edu.szu.train.business.req.ConfirmOrderTicketReq;
import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.exception.BusinessException;
import cn.edu.szu.train.common.exception.BusinessExceptionEnum;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.mapper.ConfirmOrderMapper;
import cn.edu.szu.train.business.req.ConfirmOrderQueryReq;
import cn.edu.szu.train.business.req.ConfirmOrderDoReq;
import cn.edu.szu.train.business.response.ConfirmOrderQueryResponse;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConfirmOrderService {
    private static final Logger LOG = LoggerFactory.getLogger(ConfirmOrderService.class);

    @Resource
    private ConfirmOrderMapper confirmOrderMapper;

    @Resource
    private DailyTrainTicketService dailyTrainTicketService;

    @Resource
    private DailyTrainCarriageService dailyTrainCarriageService;

    @Resource
    private DailyTrainSeatService dailyTrainSeatService;

    public void save(ConfirmOrderDoReq req) {
        DateTime now = DateTime.now();
        ConfirmOrder confirmOrder = BeanUtil.copyProperties(req, ConfirmOrder.class);
        if (ObjectUtil.isNull(confirmOrder.getId())) {
            confirmOrder.setId(SnowUtil.getSnowflakeNextId());
            confirmOrder.setCreateTime(now);
            confirmOrder.setUpdateTime(now);
            confirmOrderMapper.insert(confirmOrder);
        } else {
            confirmOrder.setUpdateTime(now);
            confirmOrderMapper.updateByPrimaryKey(confirmOrder);
        }
    }

    public PageResp<ConfirmOrderQueryResponse> queryList(ConfirmOrderQueryReq req) {
        ConfirmOrderExample confirmOrderExample = new ConfirmOrderExample();
        confirmOrderExample.setOrderByClause("id desc");
        ConfirmOrderExample.Criteria criteria = confirmOrderExample.createCriteria();

        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getPageSize());
        PageHelper.startPage(req.getPage(), req.getPageSize());
        List<ConfirmOrder> confirmOrderList = confirmOrderMapper.selectByExample(confirmOrderExample);

        PageInfo<ConfirmOrder> pageInfo = new PageInfo<>(confirmOrderList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<ConfirmOrderQueryResponse> list = BeanUtil.copyToList(confirmOrderList, ConfirmOrderQueryResponse.class);

        PageResp<ConfirmOrderQueryResponse> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setRows(list);
        return pageResp;
    }

    public void delete(Long id) {
        confirmOrderMapper.deleteByPrimaryKey(id);
    }

    public void doConfirm(ConfirmOrderDoReq req) {
        // 如：车次是否存在，余票是否存在，车次是否在有效期内，tickets条数>0，同乘客同车次是否已经买过
        Date date = req.getDate();
        String trainCode = req.getTrainCode();
        String departure = req.getDeparture();
        String destination = req.getDestination();
        List<ConfirmOrderTicketReq> tickets = req.getTickets();
        // 保存确认订单表，状态初始
        DateTime now = DateTime.now();
        ConfirmOrder confirmOrder = new  ConfirmOrder();
        confirmOrder.setId(SnowUtil.getSnowflakeNextId());
        confirmOrder.setMemberId(LoginMemberContext.getId());
        confirmOrder.setDate(date);
        confirmOrder.setDeparture(departure);
        confirmOrder.setDestination(destination);
        confirmOrder.setDailyTrainTicketId(req.getDailyTrainTicketId());
        confirmOrder.setStatus(ConfirmOrderStatusEnum.INIT.getCode());
        confirmOrder.setTickets(JSON.toJSONString(tickets));
        confirmOrder.setCreateTime(now);
        confirmOrder.setUpdateTime(now);
        confirmOrderMapper.insert(confirmOrder);
        // 查出余票记录，需要得到真实的库存
        DailyTrainTicket dailyTrainTicket = dailyTrainTicketService.selectByUnique(date, trainCode, departure, destination);
        LOG.info("查出余票记录：{}", dailyTrainTicket);
        // 扣减余票数量，并判断余票是否足够
        reduceTickets(req, dailyTrainTicket);
        // 计算相对第一个座位的偏移值
        // 比如选择的是C1，D2，则偏移值是：[0, 5]
        // 比如选择的是A1，B1，C1，则偏移值是：[0, 1, 2]
        ConfirmOrderTicketReq ticketReq0 = tickets.get(0);
        if (StrUtil.isNotBlank(ticketReq0.getSeat())) {
            LOG.info("本次购票有选座。");
            // 查出本次选座的座位类型都有哪些列，用于计算所选座位与第一个座位的偏移值
            List<SeatColEnum> seatColEnums = SeatColEnum.getColsByType(ticketReq0.getSeatTypeCode());
            LOG.info("本次选座的座位类型包含的列为：{}", seatColEnums);
            // 组成和前端两排选座一样的列表，用于做参照的座位列表，例如：referSeatColEnums = {A1, C1, D1, F1, A2, C2, D2, F2}
            List<String> referSeatList = new ArrayList<>();
            for (int i = 1; i <= 2; i++) {
                for (SeatColEnum seatColEnum: seatColEnums) {
                    referSeatList.add(seatColEnum.getCode() + i);
                }
            }
            LOG.info("用于作参照的两排座位：{}", referSeatList);
            // 绝对便宜之，即：在参照座位列表中的位置
            List<Integer> absoluteOffsetList = new ArrayList<>();
            List<Integer> relativeOffsetList = new ArrayList<>();
            for (ConfirmOrderTicketReq ticketReq: tickets) {
                int index = referSeatList.indexOf(ticketReq.getSeat());
                absoluteOffsetList.add(index);
            }
            LOG.info("计算得到所有座位的绝对偏移值：{}", absoluteOffsetList);
            for (Integer index: absoluteOffsetList) {
                int offset = index - absoluteOffsetList.get(0);
                relativeOffsetList.add(offset);
            }
            LOG.info("计算得到所有座位的相对偏移值：{}", relativeOffsetList);
            getSeat(date, trainCode, ticketReq0.getSeatTypeCode(), ticketReq0.getSeat().split("")[0], relativeOffsetList);  // 从A1变成['A', '1']，然后得到'A'
        }
        else {
            LOG.info("本次购票没有选座。");
            for (ConfirmOrderTicketReq ticketReq: tickets) {
                getSeat(date, trainCode, ticketReq0.getSeatTypeCode(), null, null);
            }
        }
        // 选座

            // 一个车厢一个车厢的获取座位数据

            // 挑选符合条件的座位，如果这个车厢不满足，则进入下个车厢（多个选座应该在同一个车厢）

        // 选中座位后事务处理

            // 修改座位表售卖情况（sell字段）

            // 修改余票信息

            // 为会员增加购票记录

            // 更新确认订单表为成功

    }

    private void getSeat(Date date, String trainCode, String seatType, String column, List<Integer> offsets) {
        List<DailyTrainCarriage> dailyTrainCarriages = dailyTrainCarriageService.selectBySeatType(date, trainCode, seatType);
        LOG.info("共查出{}个符合条件的车厢", dailyTrainCarriages.size());
        // 一个车厢一个车厢的获取座位数据
        for (DailyTrainCarriage carriage : dailyTrainCarriages) {
            LOG.info("从车厢{}开始选座", carriage.getIndex());
            List<DailyTrainSeat> dailyTrainSeats = dailyTrainSeatService.selectByCarriage(date, trainCode, carriage.getIndex());
            LOG.info("车厢{}的座位数：{}", carriage.getIndex(), dailyTrainSeats.size());
        }
    }

    private static void reduceTickets(ConfirmOrderDoReq req, DailyTrainTicket dailyTrainTicket) {
        for (ConfirmOrderTicketReq confirmOrderTicketReq : req.getTickets()) {
            String seatTypeCode = confirmOrderTicketReq.getSeatTypeCode();
            SeatTypeEnum seatTypeEnum = EnumUtil.getBy(SeatTypeEnum::getCode, seatTypeCode);
            switch (seatTypeEnum) {
                case FIRST_CLASS -> {
                    int countLeft = dailyTrainTicket.getFirstClass() - 1;
                    if (countLeft < 0) {
                        throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_TICKET_COUNT_ERROR);
                    }
                    dailyTrainTicket.setFirstClass(countLeft);
                }
                case SECOND_CLASS -> {
                    int countLeft = dailyTrainTicket.getSecondClass() - 1;
                    if (countLeft < 0) {
                        throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_TICKET_COUNT_ERROR);
                    }
                    dailyTrainTicket.setSecondClass(countLeft);
                }
                case SOFT_SLEEPER -> {
                    int countLeft = dailyTrainTicket.getSoftSleeper() - 1;
                    if (countLeft < 0) {
                        throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_TICKET_COUNT_ERROR);
                    }
                    dailyTrainTicket.setSoftSleeper(countLeft);
                }
                case HARD_SLEEPER -> {
                    int countLeft = dailyTrainTicket.getHardSleeper() - 1;
                    if (countLeft < 0) {
                        throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_TICKET_COUNT_ERROR);
                    }
                    dailyTrainTicket.setHardSleeper(countLeft);
                }
            }
        }
    }
}
