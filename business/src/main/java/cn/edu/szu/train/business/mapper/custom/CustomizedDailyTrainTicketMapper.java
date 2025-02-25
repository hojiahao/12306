package cn.edu.szu.train.business.mapper.custom;

import java.util.Date;

public interface CustomizedDailyTrainTicketMapper {

    void updateCountBySell(Date date
            , String trainCode
            , String seatTypeCode
            , Integer minStart
            , Integer maxStart
            , Integer minEnd
            , Integer maxEnd);
}
