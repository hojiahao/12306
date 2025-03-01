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
    public CommonResponse<Object> save(@Valid @RequestBody ${Domain}SaveRequest req) {
        ${domain}Service.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<${Domain}QueryResponse>> queryList(@Valid ${Domain}QueryRequest req) {
        PageResponse<${Domain}QueryResponse> queryList = ${domain}Service.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        ${domain}Service.delete(id);
        return new CommonResponse<>();
    }
}
