package cn.edu.szu.train.common.interceptor;

import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.response.MemberLoginResponse;
import cn.edu.szu.train.common.util.JwtUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * interceptor：unique to the spring framework, often used for login verification, permission verification, and request log printing.
 */
@Component
public class MemberInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(MemberInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取header的token参数
        String token = request.getHeader("token");
        if (StrUtil.isNotBlank(token)) {
            LOG.info("Get member login token:{}", token);
            JSONObject loginMember = JwtUtil.getJSONObject(token);
            LOG.info("Current Login Member:{}", loginMember);
            LoginMemberContext.setMember(JSONUtil.toBean(loginMember, MemberLoginResponse.class));
        }
        return true;
    }
}
