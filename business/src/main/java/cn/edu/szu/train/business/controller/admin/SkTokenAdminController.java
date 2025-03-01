package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.SkTokenQueryRequest;
import cn.edu.szu.train.business.request.SkTokenSaveRequest;
import cn.edu.szu.train.business.response.SkTokenQueryResponse;
import cn.edu.szu.train.business.service.SkTokenService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/sk-token")
public class SkTokenAdminController {

    @Resource
    private SkTokenService skTokenService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody SkTokenSaveRequest req) {
        skTokenService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<SkTokenQueryResponse>> queryList(@Valid SkTokenQueryRequest req) {
        PageResponse<SkTokenQueryResponse> queryList = skTokenService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        skTokenService.delete(id);
        return new CommonResponse<>();
    }
}
