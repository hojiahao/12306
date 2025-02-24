package cn.edu.szu.train.business.service;

import ch.qos.logback.classic.spi.EventArgUtil;
import cn.edu.szu.train.business.domain.ConfirmOrder;
import cn.edu.szu.train.business.domain.DailyTrainSeat;
import cn.edu.szu.train.business.domain.DailyTrainTicket;
import cn.edu.szu.train.business.enums.ConfirmOrderStatusEnum;
import cn.edu.szu.train.business.mapper.ConfirmOrderMapper;
import cn.edu.szu.train.business.mapper.DailyTrainSeatMapper;
import cn.edu.szu.train.business.mapper.DailyTrainTicketMapper;
import cn.edu.szu.train.business.req.ConfirmOrderDoReq;
import cn.edu.szu.train.business.req.ConfirmOrderTicketReq;
import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AfterConfirmOrderService {
    private static final Logger LOG = LoggerFactory.getLogger(AfterConfirmOrderService.class);

    @Resource
    private DailyTrainSeatMapper dailyTrainSeatMapper;

    @Resource
    private DailyTrainTicketMapper dailyTrainTicketMapper;

    @Resource
    private DailyTrainCarriageService dailyTrainCarriageService;

    @Resource
    private ConfirmOrderMapper confirmOrderMapper;

    /**
     * 选中座位后事务处理：
     *  座位表修改售卖情况sell；
     *  余票详情表修改余票；
     *  为会员增加购票记录
     *  更新确认订单为成功
     */
     @Transactional
    // @GlobalTransactional
    public void afterDoConfirm(List<DailyTrainSeat> dailyTrainSeats) {
         for (DailyTrainSeat seat : dailyTrainSeats) {
             DailyTrainSeat seatForUpdate = new DailyTrainSeat();
             seatForUpdate.setId(seat.getId());
             seatForUpdate.setSell(seat.getSell());
             seatForUpdate.setUpdateTime(new Date());
             dailyTrainSeatMapper.updateByPrimaryKeySelective(seatForUpdate);
         }
    }
}
