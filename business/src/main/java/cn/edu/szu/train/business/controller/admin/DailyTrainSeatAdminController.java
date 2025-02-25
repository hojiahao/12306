package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.DailyTrainSeatQueryRequest;
import cn.edu.szu.train.business.request.DailyTrainSeatSaveRequest;
import cn.edu.szu.train.business.response.DailyTrainSeatQueryResponse;
import cn.edu.szu.train.business.service.DailyTrainSeatService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-seat")
public class DailyTrainSeatAdminController {

    @Resource
    private DailyTrainSeatService dailyTrainSeatService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody DailyTrainSeatSaveRequest req) {
        dailyTrainSeatService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<DailyTrainSeatQueryResponse>> queryList(@Valid DailyTrainSeatQueryRequest req) {
        PageResponse<DailyTrainSeatQueryResponse> queryList = dailyTrainSeatService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        dailyTrainSeatService.delete(id);
        return new CommonResponse<>();
    }
}
