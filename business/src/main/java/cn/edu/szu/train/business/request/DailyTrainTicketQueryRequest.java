package cn.edu.szu.train.business.request;

import cn.edu.szu.train.common.request.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;


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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        DailyTrainTicketQueryRequest that = (DailyTrainTicketQueryRequest) object;
        return Objects.equals(date, that.date) && Objects.equals(trainCode, that.trainCode) && Objects.equals(departure, that.departure) && Objects.equals(destination, that.destination) && Objects.equals(((DailyTrainTicketQueryRequest) object).getPage(), that.getPage()) && Objects.equals(((DailyTrainTicketQueryRequest) object).getPageSize(), that.getPageSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, trainCode, departure, destination, getPage(), getPageSize());
    }

    @Override
    public String toString() {
        return "DailyTrainTicketQueryRequest{" +
                "date=" + date +
                ", trainCode='" + trainCode + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                "} " + super.toString();
    }
}