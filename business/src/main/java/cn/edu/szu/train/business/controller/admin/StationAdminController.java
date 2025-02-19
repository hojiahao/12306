package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.business.req.StationQueryReq;
import cn.edu.szu.train.business.req.StationSaveReq;
import cn.edu.szu.train.business.response.StationQueryResponse;
import cn.edu.szu.train.business.service.StationService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/station")
public class StationAdminController {

    @Resource
    private StationService stationService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody StationSaveReq req) {
        stationService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("query-list")
    public CommonResp<PageResp<StationQueryResponse>> queryList(@Valid StationQueryReq req) {
        PageResp<StationQueryResponse> queryList = stationService.queryList(req);
        return new CommonResp<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
public CommonResp<Object> delete(@PathVariable Long id) {
        stationService.delete(id);
        return new CommonResp<>();
    }
}
