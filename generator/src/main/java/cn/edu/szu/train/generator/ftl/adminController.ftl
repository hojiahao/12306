package cn.edu.szu.train.${module}.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.${module}.request.${Domain}QueryRequest;
import cn.edu.szu.train.${module}.request.${Domain}SaveRequest;
import cn.edu.szu.train.${module}.response.${Domain}QueryResponse;
import cn.edu.szu.train.${module}.service.${Domain}Service;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/${do_main}")
public class ${Domain}AdminController {

    @Resource
    private ${Domain}Service ${domain}Service;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody ${Domain}SaveRequest req) {
        ${domain}Service.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<${Domain}QueryResponse>> queryList(@Valid ${Domain}QueryRequest req) {
        PageResp<${Domain}QueryResponse> queryList = ${domain}Service.queryList(req);
        return new CommonResp<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        ${domain}Service.delete(id);
        return new CommonResp<>();
    }
}
