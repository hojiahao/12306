package cn.edu.szu.train.business.request;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ConfirmOrderDoRequest {
    /**
     * 会员id
     */
    private Long memberId;

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
    private String trainCode;

    /**
     * 出发站
     */
    @NotBlank(message = "【出发站】不能为空")
    private String departure;

    /**
     * 到达站
     */
    @NotBlank(message = "【到达站】不能为空")
    private String destination;

    /**
     * 余票ID
     */
    @NotNull(message = "【余票ID】不能为空")
    private Long dailyTrainTicketId;

    /**
     * 车票
     */
    @NotEmpty(message = "【车票】不能为空")
    private List<ConfirmOrderTicketRequest> tickets;

    /**
     * 验证码
     */
    @NotBlank(message = "【图片验证码】不能为空")
    private String imageCode;

    /**
     * 图片验证码token
     */
    @NotBlank(message = "【图片验证码】参数非法")
    private String imageCodeToken;

    /**
     * 日志跟踪号
     */
    private String logId;

    /**
     * 加入排队人数，用于体验排队功能
     */
    private int lineNumber;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Long getDailyTrainTicketId() {
        return dailyTrainTicketId;
    }

    public void setDailyTrainTicketId(Long dailyTrainTicketId) {
        this.dailyTrainTicketId = dailyTrainTicketId;
    }

    public List<ConfirmOrderTicketRequest> getTickets() {
        return tickets;
    }

    public void setTickets(List<ConfirmOrderTicketRequest> tickets) {
        this.tickets = tickets;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public String getImageCodeToken() {
        return imageCodeToken;
    }

    public void setImageCodeToken(String imageCodeToken) {
        this.imageCodeToken = imageCodeToken;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "ConfirmOrderDoRequest{" +
                "memberId=" + memberId +
                ", date=" + date +
                ", trainCode='" + trainCode + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", dailyTrainTicketId=" + dailyTrainTicketId +
                ", tickets=" + tickets +
                ", imageCode='" + imageCode + '\'' +
                ", imageCodeToken='" + imageCodeToken + '\'' +
                ", logId='" + logId + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }
}