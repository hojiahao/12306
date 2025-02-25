package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.ConfirmOrderQueryRequest;
import cn.edu.szu.train.business.request.ConfirmOrderDoRequest;
import cn.edu.szu.train.business.response.ConfirmOrderQueryResponse;
import cn.edu.szu.train.business.service.ConfirmOrderService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/confirm-order")
public class ConfirmOrderAdminController {

    @Resource
    private ConfirmOrderService confirmOrderService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody ConfirmOrderDoRequest req) {
        confirmOrderService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<ConfirmOrderQueryResponse>> queryList(@Valid ConfirmOrderQueryRequest req) {
        PageResponse<ConfirmOrderQueryResponse> queryList = confirmOrderService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        confirmOrderService.delete(id);
        return new CommonResponse<>();
    }
}
