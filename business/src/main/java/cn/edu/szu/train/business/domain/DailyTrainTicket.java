package cn.edu.szu.train.business.domain;

import java.math.BigDecimal;
import java.util.Date;

public class DailyTrainTicket {
    private Long id;

    private Date date;

    private String trainCode;

    private String departure;

    private String departurePinyin;

    private Date departureTime;

    private Integer departureIndex;

    private String destination;

    private String destinationPinyin;

    private Date arrivalTime;

    private Integer arrivalIndex;

    private Integer firstClass;

    private BigDecimal firstClassPrice;

    private Integer secondClass;

    private BigDecimal secondClassPrice;

    private Integer softSleeper;

    private BigDecimal softSleeperPrice;

    private Integer hardSleeper;

    private BigDecimal hardSleeperPrice;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getDepartureIndex() {
        return departureIndex;
    }

    public void setDepartureIndex(Integer departureIndex) {
        this.departureIndex = departureIndex;
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

    public Integer getArrivalIndex() {
        return arrivalIndex;
    }

    public void setArrivalIndex(Integer arrivalIndex) {
        this.arrivalIndex = arrivalIndex;
    }

    public Integer getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(Integer firstClass) {
        this.firstClass = firstClass;
    }

    public BigDecimal getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(BigDecimal firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public Integer getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(Integer secondClass) {
        this.secondClass = secondClass;
    }

    public BigDecimal getSecondClassPrice() {
        return secondClassPrice;
    }

    public void setSecondClassPrice(BigDecimal secondClassPrice) {
        this.secondClassPrice = secondClassPrice;
    }

    public Integer getSoftSleeper() {
        return softSleeper;
    }

    public void setSoftSleeper(Integer softSleeper) {
        this.softSleeper = softSleeper;
    }

    public BigDecimal getSoftSleeperPrice() {
        return softSleeperPrice;
    }

    public void setSoftSleeperPrice(BigDecimal softSleeperPrice) {
        this.softSleeperPrice = softSleeperPrice;
    }

    public Integer getHardSleeper() {
        return hardSleeper;
    }

    public void setHardSleeper(Integer hardSleeper) {
        this.hardSleeper = hardSleeper;
    }

    public BigDecimal getHardSleeperPrice() {
        return hardSleeperPrice;
    }

    public void setHardSleeperPrice(BigDecimal hardSleeperPrice) {
        this.hardSleeperPrice = hardSleeperPrice;
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
        sb.append(", date=").append(date);
        sb.append(", trainCode=").append(trainCode);
        sb.append(", departure=").append(departure);
        sb.append(", departurePinyin=").append(departurePinyin);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", departureIndex=").append(departureIndex);
        sb.append(", destination=").append(destination);
        sb.append(", destinationPinyin=").append(destinationPinyin);
        sb.append(", arrivalTime=").append(arrivalTime);
        sb.append(", arrivalIndex=").append(arrivalIndex);
        sb.append(", firstClass=").append(firstClass);
        sb.append(", firstClassPrice=").append(firstClassPrice);
        sb.append(", secondClass=").append(secondClass);
        sb.append(", secondClassPrice=").append(secondClassPrice);
        sb.append(", softSleeper=").append(softSleeper);
        sb.append(", softSleeperPrice=").append(softSleeperPrice);
        sb.append(", hardSleeper=").append(hardSleeper);
        sb.append(", hardSleeperPrice=").append(hardSleeperPrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}