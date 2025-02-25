package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.DailyTrainStationQueryRequest;
import cn.edu.szu.train.business.request.DailyTrainStationSaveRequest;
import cn.edu.szu.train.business.response.DailyTrainStationQueryResponse;
import cn.edu.szu.train.business.service.DailyTrainStationService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-station")
public class DailyTrainStationAdminController {

    @Resource
    private DailyTrainStationService dailyTrainStationService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody DailyTrainStationSaveRequest req) {
        dailyTrainStationService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<DailyTrainStationQueryResponse>> queryList(@Valid DailyTrainStationQueryRequest req) {
        PageResponse<DailyTrainStationQueryResponse> queryList = dailyTrainStationService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        dailyTrainStationService.delete(id);
        return new CommonResponse<>();
    }
}
