package cn.edu.szu.train.member.req;

import jakarta.validation.constraints.NotBlank;

public class MemberRegisterReq {
    @NotBlank(message = "Mobile phone number cannot be empty!")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MemberRegisterReq{" +
                "mobile='" + phoneNumber + '\'' +
                '}';
    }
}
