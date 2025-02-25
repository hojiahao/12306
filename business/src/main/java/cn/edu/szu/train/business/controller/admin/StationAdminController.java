package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.StationQueryRequest;
import cn.edu.szu.train.business.request.StationSaveRequest;
import cn.edu.szu.train.business.response.StationQueryResponse;
import cn.edu.szu.train.business.service.StationService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/station")
public class StationAdminController {

    @Resource
    private StationService stationService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody StationSaveRequest req) {
        stationService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<StationQueryResponse>> queryList(@Valid StationQueryRequest req) {
        PageResponse<StationQueryResponse> queryList = stationService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        stationService.delete(id);
        return new CommonResponse<>();
    }

    @GetMapping("/query-all")
    public CommonResponse<List<StationQueryResponse>> queryAll() {
        List<StationQueryResponse> list = stationService.queryAll();
        return new CommonResponse<>(list);
    }
}
