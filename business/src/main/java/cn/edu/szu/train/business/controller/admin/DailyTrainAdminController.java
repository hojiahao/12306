package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.DailyTrainQueryRequest;
import cn.edu.szu.train.business.request.DailyTrainSaveRequest;
import cn.edu.szu.train.business.response.DailyTrainQueryResponse;
import cn.edu.szu.train.business.service.DailyTrainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/daily-train")
public class DailyTrainAdminController {

    @Resource
    private DailyTrainService dailyTrainService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody DailyTrainSaveRequest req) {
        dailyTrainService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<DailyTrainQueryResponse>> queryList(@Valid DailyTrainQueryRequest req) {
        PageResponse<DailyTrainQueryResponse> queryList = dailyTrainService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        dailyTrainService.delete(id);
        return new CommonResponse<>();
    }

    /**
     * 生成某日所有车次信息，包括车次、车站、车厢、座位
     * @param date
     * @return
     */
    @GetMapping("/generate-daily-train/{date}")
    public CommonResponse<Object> generateDailyTrain(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        dailyTrainService.generate(date);
        return new CommonResponse<>();
    }
}
