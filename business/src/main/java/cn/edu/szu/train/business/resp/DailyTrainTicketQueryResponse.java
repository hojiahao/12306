package cn.edu.szu.train.business.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;

public class DailyTrainTicketQueryResponse {

    /**
     * id
     */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
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
     * 出发站拼音
     */
    private String departurePinyin;

    /**
     * 出发时间
     */
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    private Date departureTime;

    /**
     * 出发站序|本站是整个车次的第几站
     */
    private Integer departureIndex;

    /**
     * 到达站
     */
    private String destination;

    /**
     * 到达站拼音
     */
    private String destinationPinyin;

    /**
     * 到站时间
     */
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    private Date arrivalTime;

    /**
     * 到站站序|本站是整个车次的第几站
     */
    private Integer arrivalIndex;

    /**
     * 一等座余票
     */
    private Integer firstClass;

    /**
     * 一等座票价
     */
    private BigDecimal firstClassPrice;

    /**
     * 二等座余票
     */
    private Integer secondClass;

    /**
     * 二等座票价
     */
    private BigDecimal secondClassPrice;

    /**
     * 软卧余票
     */
    private Integer softSleeper;

    /**
     * 软卧票价
     */
    private BigDecimal softSleeperPrice;

    /**
     * 硬卧余票
     */
    private Integer hardSleeper;

    /**
     * 硬卧票价
     */
    private BigDecimal hardSleeperPrice;

    /**
     * 新增时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
