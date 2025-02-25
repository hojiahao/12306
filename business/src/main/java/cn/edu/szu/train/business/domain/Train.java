package cn.edu.szu.train.business.domain;

import java.io.Serializable;
import java.util.Date;

public class Train implements Serializable {
    private Long id;

    private String code;

    private String type;

    private String departure;

    private String departurePinyin;

    private Date departureTime;

    private String destination;

    private String destinationPinyin;

    private Date arrivalTime;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDeparturePinyin() {
        return departurePinyin;
    }

    public void setDeparturePinyin(String departurePinyin) {
        this.departurePinyin = departurePinyin;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationPinyin() {
        return destinationPinyin;
    }

    public void setDestinationPinyin(String destinationPinyin) {
        this.destinationPinyin = destinationPinyin;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", departure=").append(departure);
        sb.append(", departurePinyin=").append(departurePinyin);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", destination=").append(destination);
        sb.append(", destinationPinyin=").append(destinationPinyin);
        sb.append(", arrivalTime=").append(arrivalTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}