package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.DailyTrainCarriageQueryRequest;
import cn.edu.szu.train.business.request.DailyTrainCarriageSaveRequest;
import cn.edu.szu.train.business.response.DailyTrainCarriageQueryResponse;
import cn.edu.szu.train.business.service.DailyTrainCarriageService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-carriage")
public class DailyTrainCarriageAdminController {

    @Resource
    private DailyTrainCarriageService dailyTrainCarriageService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody DailyTrainCarriageSaveRequest req) {
        dailyTrainCarriageService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<DailyTrainCarriageQueryResponse>> queryList(@Valid DailyTrainCarriageQueryRequest req) {
        PageResponse<DailyTrainCarriageQueryResponse> queryList = dailyTrainCarriageService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        dailyTrainCarriageService.delete(id);
        return new CommonResponse<>();
    }
}
