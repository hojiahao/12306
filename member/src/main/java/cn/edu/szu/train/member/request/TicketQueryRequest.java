package cn.edu.szu.train.member.request;

import cn.edu.szu.train.common.request.PageRequest;


public class TicketQueryRequest extends PageRequest {
    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "TicketQueryReq{" +
                "memberId=" + memberId +
                "} " + super.toString();
    }
}