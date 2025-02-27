package cn.edu.szu.train.business.service;

import cn.edu.szu.train.business.domain.ConfirmOrder;
import cn.edu.szu.train.business.domain.DailyTrainSeat;
import cn.edu.szu.train.business.domain.DailyTrainTicket;
import cn.edu.szu.train.business.enums.ConfirmOrderStatusEnum;
import cn.edu.szu.train.business.feign.MemberFeign;
import cn.edu.szu.train.business.mapper.ConfirmOrderMapper;
import cn.edu.szu.train.business.mapper.DailyTrainSeatMapper;
import cn.edu.szu.train.business.mapper.custom.CustomizedDailyTrainTicketMapper;
import cn.edu.szu.train.business.request.ConfirmOrderTicketRequest;
import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.request.MemberTicketRequest;
import cn.edu.szu.train.common.response.CommonResponse;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
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

    @Resource
    private MemberFeign memberFeign;

    @Resource
    private ConfirmOrderMapper confirmOrderMapper;

    /**
     * 选中座位后事务处理：
     * 座位表修改售卖情况sell；
     * 余票详情表修改余票；
     * 为会员增加购票记录
     * 更新确认订单为成功
     */
//    @Transactional
//     @GlobalTransactional
    public void afterDoConfirm(DailyTrainTicket dailyTrainTicket, List<DailyTrainSeat> seats, List<ConfirmOrderTicketRequest> tickets, ConfirmOrder confirmOrder) throws Exception {
        LOG.info("seata全局事务ID:{}", RootContext.getXID());
         for (int i = 0; i < seats.size(); i++) {
            DailyTrainSeat seatForUpdate = new DailyTrainSeat();
            DailyTrainSeat dailyTrainSeat = seats.get(i);
            seatForUpdate.setId(dailyTrainSeat.getId());
            seatForUpdate.setSell(dailyTrainSeat.getSell());
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
            for (int j = start - 1; j >= 0; j--) {
                char aChar = chars[j - 1];
                if (aChar == '1') {
                    minStart = j + 2;
                    break;
                }
            }
            LOG.info("影响的出发站区间为：{}-{}", minStart, maxStart);
            Integer maxEnd = seatForUpdate.getSell().length() + 1;
            for (int j = end - 1; j < seatForUpdate.getSell().length(); j++) {
                char aChar = chars[j];
                if (aChar == '1') {
                    maxEnd = j + 1;
                    break;
                }
            }
            LOG.info("影响的到达站区间为：{}-{}", minEnd, maxEnd);
            customizedDailyTrainTicketMapper.updateCountBySell(
                    seats.get(i).getDate(),
                    seats.get(i).getTrainCode(),
                    seats.get(i).getSeatType(),
                    minStart,
                    maxStart,
                    minEnd,
                    maxEnd
            );
            // 调用会员服务接口，为会员增加一张车票
            MemberTicketRequest memberTicketRequest = new MemberTicketRequest();
            memberTicketRequest.setMemberId(LoginMemberContext.getId());
            memberTicketRequest.setPassengerId(tickets.get(i).getPassengerId());
            memberTicketRequest.setPassengerName(tickets.get(i).getPassengerName());
            memberTicketRequest.setTrainDate(dailyTrainTicket.getDate());
            memberTicketRequest.setTrainCode(dailyTrainTicket.getTrainCode());
            memberTicketRequest.setCarriageIndex(dailyTrainSeat.getCarriageIndex());
            memberTicketRequest.setSeatType(seats.get(i).getSeatType());
            memberTicketRequest.setSeatRow(dailyTrainSeat.getRow());
            memberTicketRequest.setSeatCol(dailyTrainSeat.getCol());
            memberTicketRequest.setDepartureStation(dailyTrainTicket.getDeparture());
            memberTicketRequest.setDepartureTime(dailyTrainTicket.getDepartureTime());
            memberTicketRequest.setDestinationStation(dailyTrainTicket.getDestination());
            memberTicketRequest.setArrivalTime(dailyTrainTicket.getArrivalTime());
            CommonResponse<Object> commonResponse = memberFeign.save(memberTicketRequest);
            LOG.info("调用member接口，返回{}", commonResponse);
            //更新订单状态为成功
            ConfirmOrder confirmOrderForUpdate = new ConfirmOrder();
            confirmOrderForUpdate.setId(confirmOrder.getId());
            confirmOrderForUpdate.setUpdateTime(new Date());
            confirmOrderForUpdate.setStatus(ConfirmOrderStatusEnum.SUCCESS.getCode());
            confirmOrderMapper.updateByPrimaryKeySelective(confirmOrderForUpdate);
            // 模拟调用方出现异常
             // Thread.sleep(10000)
             if (i == 1) {
                 throw new Exception("测试异常。");
             }
         }
    }
}
