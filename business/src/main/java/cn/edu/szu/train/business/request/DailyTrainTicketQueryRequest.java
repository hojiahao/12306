package cn.edu.szu.train.business.request;

import cn.edu.szu.train.common.request.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class DailyTrainTicketQueryRequest extends PageRequest {
    /**
     * 日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    /**
     * 车次编号
     */
    private String trainCode;

    /**
     * 出发站
     */
    private String departure;

    /**
     * 到达站
     */
    private String destination;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "DailyTrainTicketQueryReq{" +
                "date=" + date +
                ", trainCode='" + trainCode + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                "} " + super.toString();
    }
}