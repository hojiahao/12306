package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.request.ConfirmOrderDoRequest;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {
    private static final Logger LOG = LoggerFactory.getLogger(ConfirmOrderController.class);

    @Resource
    private ConfirmOrderService confirmOrderService;

    @SentinelResource(value = "confirm-order", blockHandler = "doConfirmBlock")
    @PostMapping("/do")
    public CommonResponse<Object> doConfirm(@Valid @RequestBody ConfirmOrderDoRequest req) {
        confirmOrderService.doConfirm(req);
        return new CommonResponse<>();
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
