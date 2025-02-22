package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.business.req.DailyTrainQueryReq;
import cn.edu.szu.train.business.req.DailyTrainSaveReq;
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
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainSaveReq req) {
        dailyTrainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("query-list")
    public CommonResp<PageResp<DailyTrainQueryResponse>> queryList(@Valid DailyTrainQueryReq req) {
        PageResp<DailyTrainQueryResponse> queryList = dailyTrainService.queryList(req);
        return new CommonResp<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainService.delete(id);
        return new CommonResp<>();
    }

    /**
     * 生成某日所有车次信息，包括车次、车站、车厢、座位
     * @param date
     * @return
     */
    @GetMapping("/generate-daily-train/{date}")
    public CommonResp<Object> generateDailyTrain(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        dailyTrainService.generate(date);
        return new CommonResp<>();
    }
}
