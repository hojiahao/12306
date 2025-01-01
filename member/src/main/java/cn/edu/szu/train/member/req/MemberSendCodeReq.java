package cn.edu.szu.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MemberSendCodeReq {
    @NotBlank(message = "Mobile phone number cannot be empty!")
    @Pattern(regexp = "^1\\d{10}$", message = "The mobile number format is incorrect!")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MemberSendCodeReq{" +
                "mobile='" + phoneNumber + '\'' +
                '}';
    }
}
