package cn.edu.szu.train.business.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TrainStationSaveRequest {
    /**
     * id
     */
    private Long id;

    /**
     * 车次编号
     */
    @NotBlank(message = "【车次编号】不能为空")
    private String trainCode;

    /**
     * 站序
     */
    @NotNull(message = "【站序】不能为空")
    private Integer index;

    /**
     * 车站名
     */
    @NotBlank(message = "【车站名】不能为空")
    private String name;

    /**
     * 车站名拼音
     */
    @NotBlank(message = "【车站名拼音】不能为空")
    private String namePinyin;

    /**
     * 进站时间
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date entryTime;

    /**
     * 出站时间
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date exitTime;

    /**
     * 停留时间
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date stopTime;

    /**
     * 里程（公里）|上一站到本站的距离
     */
    @NotNull(message = "【里程（公里）】不能为空")
    private BigDecimal kilometers;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public BigDecimal getKilometers() {
        return kilometers;
    }

    public void setKilometers(BigDecimal kilometers) {
        this.kilometers = kilometers;
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
        sb.append(", trainCode=").append(trainCode);
        sb.append(", index=").append(index);
        sb.append(", name=").append(name);
        sb.append(", namePinyin=").append(namePinyin);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", exitTime=").append(exitTime);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", kilometers=").append(kilometers);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}