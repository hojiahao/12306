package cn.edu.szu.train.member.req;

import cn.edu.szu.train.common.request.PageRequest;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class PassengerQueryReq extends PageRequest {
    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberId=").append(memberId);
        sb.append("]");
        return sb.toString();
    }
}