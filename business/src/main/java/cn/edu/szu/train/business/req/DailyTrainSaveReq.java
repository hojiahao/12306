package cn.edu.szu.train.business.req;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DailyTrainSaveReq {
    /**
     * id
     */
    private Long id;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @NotNull(message = "【日期】不能为空")
    private Date date;

    /**
     * 车次编号
     */
    @NotBlank(message = "【车次编号】不能为空")
    private String code;

    /**
     * 车次类型|枚举[TrainTypeEnum]
     */
    @NotBlank(message = "【车次类型】不能为空")
    private String type;

    /**
     * 始发站
     */
    @NotBlank(message = "【始发站】不能为空")
    private String departure;

    /**
     * 始发站拼音
     */
    @NotBlank(message = "【始发站拼音】不能为空")
    private String departurePinyin;

    /**
     * 出发时间
     */
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    @NotNull(message = "【出发时间】不能为空")
    private Date departureTime;

    /**
     * 终点站
     */
    @NotBlank(message = "【终点站】不能为空")
    private String destination;

    /**
     * 终点站拼音
     */
    @NotBlank(message = "【终点站拼音】不能为空")
    private String destinationPinyin;

    /**
     * 到站时间
     */
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    @NotNull(message = "【到站时间】不能为空")
    private Date arrivalTime;

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
        sb.append(", date=").append(date);
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