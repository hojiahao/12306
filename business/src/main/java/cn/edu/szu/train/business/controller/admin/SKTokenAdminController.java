package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.SKTokenQueryRequest;
import cn.edu.szu.train.business.request.SKTokenSaveRequest;
import cn.edu.szu.train.business.response.SKTokenQueryResponse;
import cn.edu.szu.train.business.service.SKTokenService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/sk-token")
public class SKTokenAdminController {

    @Resource
    private SKTokenService skTokenService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody SKTokenSaveRequest req) {
        skTokenService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<SKTokenQueryResponse>> queryList(@Valid SKTokenQueryRequest req) {
        PageResponse<SKTokenQueryResponse> queryList = skTokenService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        skTokenService.delete(id);
        return new CommonResponse<>();
    }
}
