package cn.edu.szu.train.member.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MemberLoginRequest {
    @NotBlank(message = "Mobile phone number cannot be empty!")
    @Pattern(regexp = "^1\\d{10}$", message = "The mobile number format is incorrect!")
    private String mobile;

    @NotBlank(message = "The SMS verification code cannot be empty")
    private String code;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
        sb.append("phoneNumber='").append(mobile).append('\'');
        sb.append(", code=").append(code);
        sb.append('}');
        return sb.toString();
    }
}
