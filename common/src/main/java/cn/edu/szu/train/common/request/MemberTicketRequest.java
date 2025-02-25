package cn.edu.szu.train.common.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class MemberTicketRequest {

    /**
     * 乘客id
     */
    @NotNull(message = "【会员id】不能为空")
    private Long memberId;

    /**
     * 乘客id
     */
    @NotNull(message = "【乘客id】不能为空")
    private Long passengerId;

    /**
     * 乘客id
     */
    @NotNull(message = "【乘客名字】不能为空")
    private String passengerName;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @NotNull(message = "【日期】不能为空")
    private Date Date;

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    /**
     * 车次编号
     */
    @NotBlank(message = "【车次编号】不能为空")
    private String trainCode;

    /**
     * 箱序
     */
    @NotNull(message = "【箱序】不能为空")
    private Integer carriageIndex;

    /**
     * 排号|01, 02
     */
    @NotBlank(message = "【排号】不能为空")
    private String row;

    /**
     * 列号|枚举[SeatColumnEnum]
     */
    @NotBlank(message = "【列号】不能为空")
    private String col;

    /**
     * 出发站
     */
    @NotBlank(message = "【出发站】不能为空")
    private String departure;

    /**
     * 出发时间
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    @NotNull(message = "【出发时间】不能为空")
    private Date departureTime;

    /**
     * 到达站
     */
    @NotBlank(message = "【到达站】不能为空")
    private String destination;

    /**
     * 到站时间
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    @NotNull(message = "【到站时间】不能为空")
    private Date arrivalTime;

    /**
     * 座位类型|枚举[SeatTypeEnum]
     */
    @NotBlank(message = "【座位类型】不能为空")
    private String seatType;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public Integer getCarriageIndex() {
        return carriageIndex;
    }

    public void setCarriageIndex(Integer carriageIndex) {
        this.carriageIndex = carriageIndex;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public java.util.Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(java.util.Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public java.util.Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(java.util.Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "MemberTicketRequest{" +
                "memberId=" + memberId +
                ", passengerId=" + passengerId +
                ", passengerName='" + passengerName + '\'' +
                ", Date=" + Date +
                ", trainCode='" + trainCode + '\'' +
                ", carriageIndex=" + carriageIndex +
                ", row='" + row + '\'' +
                ", col='" + col + '\'' +
                ", departure='" + departure + '\'' +
                ", departureTime=" + departureTime +
                ", destination='" + destination + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", seatType='" + seatType + '\'' +
                '}';
    }
}

