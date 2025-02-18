package cn.edu.szu.train.${module}.controller;

import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.${module}.req.${Domain}QueryReq;
import cn.edu.szu.train.${module}.req.${Domain}SaveReq;
import cn.edu.szu.train.${module}.response.${Domain}QueryResponse;
import cn.edu.szu.train.${module}.service.${Domain}Service;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${do_main}")
public class ${Domain}Controller {

    @Resource
    private ${Domain}Service ${domain}Service;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody ${Domain}SaveReq req) {
        ${domain}Service.save(req);
        return new CommonResp<>();
    }

    @GetMapping("query-list")
    public CommonResp<PageResp<${Domain}QueryResponse>> queryList(@Valid ${Domain}QueryReq req) {
        PageResp<${Domain}QueryResponse> queryList = ${domain}Service.queryList(req);
        return new CommonResp<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
public CommonResp<Object> delete(@PathVariable Long id) {
        ${domain}Service.delete(id);
        return new CommonResp<>();
    }
}
