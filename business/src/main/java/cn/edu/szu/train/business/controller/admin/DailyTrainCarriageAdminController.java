package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.business.req.DailyTrainCarriageQueryReq;
import cn.edu.szu.train.business.req.DailyTrainCarriageSaveReq;
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
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainCarriageSaveReq req) {
        dailyTrainCarriageService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainCarriageQueryResponse>> queryList(@Valid DailyTrainCarriageQueryReq req) {
        PageResp<DailyTrainCarriageQueryResponse> queryList = dailyTrainCarriageService.queryList(req);
        return new CommonResp<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainCarriageService.delete(id);
        return new CommonResp<>();
    }
}
