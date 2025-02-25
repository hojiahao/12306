package cn.edu.szu.train.business.request;

import cn.edu.szu.train.common.request.PageRequest;


public class DailyTrainSeatQueryRequest extends PageRequest {
    private String trainCode;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
    public String toString() {
        return "DailyTrainSeatQueryReq{" +
                "trainCode='" + trainCode + '\'' +
                "} " + super.toString();
    }
}