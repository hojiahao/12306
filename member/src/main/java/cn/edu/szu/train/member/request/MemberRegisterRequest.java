package cn.edu.szu.train.member.request;

import jakarta.validation.constraints.NotBlank;

public class MemberRegisterRequest {
    @NotBlank(message = "Mobile phone number cannot be empty!")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberRegisterReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
