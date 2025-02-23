package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.req.ConfirmOrderDoReq;
import cn.edu.szu.train.business.req.ConfirmOrderQueryReq;
import cn.edu.szu.train.business.response.ConfirmOrderQueryResponse;
import cn.edu.szu.train.business.service.ConfirmOrderService;
import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {

    @Resource
    private ConfirmOrderService confirmOrderService;

    @PostMapping("/do")
    public CommonResp<Object> doConfirm(@Valid @RequestBody ConfirmOrderDoReq req) {
        confirmOrderService.doConfirm(req);
        return new CommonResp<>();
    }
}
