package cn.edu.szu.train.common.context;

import cn.edu.szu.train.common.response.MemberLoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginMemberContext {
    private static final Logger LOG = LoggerFactory.getLogger(LoginMemberContext.class);
    private static final ThreadLocal<MemberLoginResponse> member = new ThreadLocal<MemberLoginResponse>();

    public static MemberLoginResponse getMember() {
        return member.get();
    }

    public static void setMember(MemberLoginResponse member) {
        LoginMemberContext.member.set(member);
    }

    public static Long getId() {
        try {
            return member.get().getId();
        } catch (Exception e) {
            LOG.error("Abnormal acquisition of login member information", e);
            throw e;
        }
    }
}
