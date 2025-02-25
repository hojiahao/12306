package cn.edu.szu.train.business.service;

import cn.edu.szu.train.business.domain.DailyTrainSeat;
import cn.edu.szu.train.business.domain.DailyTrainTicket;
import cn.edu.szu.train.business.mapper.DailyTrainSeatMapper;
import cn.edu.szu.train.business.mapper.custom.CustomizedDailyTrainTicketMapper;
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
    private CustomizedDailyTrainTicketMapper customizedDailyTrainTicketMapper;

    /**
     * 选中座位后事务处理：
     * 座位表修改售卖情况sell；
     * 余票详情表修改余票；
     * 为会员增加购票记录
     * 更新确认订单为成功
     */
    @Transactional
    // @GlobalTransactional
    public void afterDoConfirm(DailyTrainTicket dailyTrainTicket, List<DailyTrainSeat> dailyTrainSeats) {
        for (DailyTrainSeat seat : dailyTrainSeats) {
            DailyTrainSeat seatForUpdate = new DailyTrainSeat();
            seatForUpdate.setId(seat.getId());
            seatForUpdate.setSell(seat.getSell());
            seatForUpdate.setUpdateTime(new Date());
            dailyTrainSeatMapper.updateByPrimaryKeySelective(seatForUpdate);
            // 计算当前站的座位卖出去之后，影响哪些站的余票库存
            // 影响的库存是本次选座之前没卖过票的和本次购票区间有交集的区间
            // 假设10个站，本次购买5~8站，站序从1开始
            // 原售票信息：001000001
            // 购票区间：000011100
            // 影响区间：XXX11111X
            Integer start = dailyTrainTicket.getDepartureIndex();
            Integer end = dailyTrainTicket.getArrivalIndex();
            char[] chars = seatForUpdate.getSell().toCharArray();
            int maxStart = end - 1;
            int minEnd = start + 1;
            Integer minStart = 1;
            for (int i = start - 1; i >= 0; i--) {
                char aChar = chars[i - 1];
                if (aChar == '1') {
                    minStart = i + 2;
                    break;
                }
            }
            LOG.info("影响的出发站区间为：{}-{}", minStart, maxStart);
            Integer maxEnd = seatForUpdate.getSell().length() + 1;
            for (int i = end - 1; i < seatForUpdate.getSell().length(); i++) {
                char aChar = chars[i];
                if (aChar == '1') {
                    maxEnd = i + 1;
                    break;
                }
            }
            LOG.info("影响的到达站区间为：{}-{}", minEnd, maxEnd);
            customizedDailyTrainTicketMapper.updateCountBySell(
                    seat.getDate(),
                    seat.getTrainCode(),
                    seat.getSeatType(),
                    minStart,
                    maxStart,
                    minEnd,
                    maxEnd
            );
        }
    }
}
