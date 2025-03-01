package cn.edu.szu.train.gateway.config;

import cn.edu.szu.train.gateway.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoginMemberFilter implements Ordered, GlobalFilter {

    private static final Logger LOG = LoggerFactory.getLogger(LoginMemberFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();

        // 排除不需要拦截的请求
        if (path.contains("/admin")
                || path.contains("/redis")
                || path.contains("/hello")
                || path.contains("/member/member/login")
                || path.contains("/member/member/send-code")
                || path.contains("/business/kaptcha")) {
            LOG.info("No login verification required:{}", path);
            return chain.filter(exchange);
        } else {
            LOG.info("Login verification required:{}", path);
        }
        // 获取header的token参数
        String token = exchange.getRequest().getHeaders().getFirst("token");
        LOG.info("Member login verification starts, token：{}", token);
        if (token == null || token.isEmpty()) {
            LOG.info( "The token is empty and the request is blocked." );
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // 校验token是否有效，包括token是否被改过，是否过期
        boolean validate = JwtUtil.validate(token);
        if (validate) {
            LOG.info("The token is valid, so the request is allowed.");
            return chain.filter(exchange);
        } else {
            LOG.warn( "The token is invalid and the request is blocked." );
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

    }

    /**
     * 优先级设置  值越小  优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
