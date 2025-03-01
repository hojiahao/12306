package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.request.ConfirmOrderDoRequest;
import cn.edu.szu.train.business.service.BeforeConfirmOrderService;
import cn.edu.szu.train.business.service.ConfirmOrderService;
import cn.edu.szu.train.common.exception.BusinessException;
import cn.edu.szu.train.common.exception.BusinessExceptionEnum;
import cn.edu.szu.train.common.response.CommonResponse;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {
    private static final Logger LOG = LoggerFactory.getLogger(ConfirmOrderController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("dev")
    private String env;

    @Autowired
    private BeforeConfirmOrderService beforeConfirmOrderService;

    // 接口的资源名称不要和接口路径一致，会导致限流后走不到降级方法中
    @SentinelResource(value = "confirmOrderDo", blockHandler = "doConfirmBlock")
    @PostMapping("/do")
    public CommonResponse<Object> doConfirm(@Valid @RequestBody ConfirmOrderDoRequest req) {
        if (!env.equals("dev")) {
            // 图形验证码校验
            String imageCodeToken = req.getImageCodeToken();
            String imageCode = req.getImageCode();
            String imageCodeRedis = stringRedisTemplate.opsForValue().get(imageCodeToken);
            LOG.info("从redis中获取到的验证码：{}", imageCodeRedis);
            if (ObjectUtils.isEmpty(imageCodeRedis)) {
                return new CommonResponse<>(false, "验证码已过期", null);
            }
            // 验证码校验，大小写忽略，提升体验，比如Oo Vv Ww容易混
            if (!imageCodeRedis.equalsIgnoreCase(imageCode)) {
                return new CommonResponse<>(false, "验证码不正确", null);
            } else {
                // 验证通过后，移除验证码
                stringRedisTemplate.delete(imageCodeToken);
            }
        }
        Long id = beforeConfirmOrderService.beforeDoConfirm(req);
        return new CommonResponse<>(String.valueOf(id));
    }

    /**
     * 降级方法，需包含限流方法的所有参数和BlockException参数
     * @param req
     * @param e
     */
    public CommonResponse<Object> doConfirmBlock(ConfirmOrderDoRequest req, BlockException e) {
        LOG.info("ConfirmOrderController购票请求被限流：{}", req);
        CommonResponse<Object> commonResponse = new CommonResponse<>();
        commonResponse.setMessage(BusinessExceptionEnum.CONFIRM_ORDER_FLOW_EXCEPTION.getDesc());
        return commonResponse;
    }
}
