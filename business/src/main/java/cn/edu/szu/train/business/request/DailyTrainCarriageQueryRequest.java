package cn.edu.szu.train.business.request;

import cn.edu.szu.train.common.request.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class DailyTrainCarriageQueryRequest extends PageRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String trainCode;

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

    @Override
    public String toString() {
        return "DailyTrainCarriageQueryReq{" +
                "date=" + date +
                ", trainCode='" + trainCode + '\'' +
                "} " + super.toString();
    }
}