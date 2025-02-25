package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.request.ConfirmOrderDoRequest;
import cn.edu.szu.train.business.service.ConfirmOrderService;
import cn.edu.szu.train.common.response.CommonResponse;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {

    @Resource
    private ConfirmOrderService confirmOrderService;

    @PostMapping("/do")
    public CommonResponse<Object> doConfirm(@Valid @RequestBody ConfirmOrderDoRequest req) {
        confirmOrderService.doConfirm(req);
        return new CommonResponse<>();
    }
}
