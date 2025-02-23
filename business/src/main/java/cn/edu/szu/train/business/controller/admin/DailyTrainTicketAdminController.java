package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.business.req.DailyTrainTicketQueryReq;
import cn.edu.szu.train.business.req.DailyTrainTicketSaveReq;
import cn.edu.szu.train.business.response.DailyTrainTicketQueryResponse;
import cn.edu.szu.train.business.service.DailyTrainTicketService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-ticket")
public class DailyTrainTicketAdminController {

    @Resource
    private DailyTrainTicketService dailyTrainTicketService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainTicketSaveReq req) {
        dailyTrainTicketService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainTicketQueryResponse>> queryList(@Valid DailyTrainTicketQueryReq req) {
        PageResp<DailyTrainTicketQueryResponse> queryList = dailyTrainTicketService.queryList(req);
        return new CommonResp<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainTicketService.delete(id);
        return new CommonResp<>();
    }
}
