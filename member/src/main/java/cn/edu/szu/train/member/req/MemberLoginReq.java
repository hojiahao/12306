package cn.edu.szu.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MemberLoginReq {
    @NotBlank(message = "Mobile phone number cannot be empty!")
    @Pattern(regexp = "^1\\d{10}$", message = "The mobile number format is incorrect!")
    private String phoneNumber;

    @NotBlank(message = "The SMS verification code cannot be empty")
    private String code;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code.toString();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberLoginReq{");
        sb.append("phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", code=").append(code);
        sb.append('}');
        return sb.toString();
    }
}
