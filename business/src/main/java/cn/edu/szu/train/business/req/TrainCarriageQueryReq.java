package cn.edu.szu.train.business.req;

import cn.edu.szu.train.common.request.PageRequest;


public class TrainCarriageQueryReq extends PageRequest {

    private String trainCode;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
    public String toString() {
        return "TrainCarriageQueryReq{" +
                "trainCode='" + trainCode + '\'' +
                "} " + super.toString();
    }
}