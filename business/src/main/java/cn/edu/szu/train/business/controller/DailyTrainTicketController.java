package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.req.DailyTrainTicketQueryReq;
import cn.edu.szu.train.business.req.DailyTrainTicketSaveReq;
import cn.edu.szu.train.business.response.DailyTrainTicketQueryResponse;
import cn.edu.szu.train.business.service.DailyTrainTicketService;
import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/daily-train-ticket")
public class DailyTrainTicketController {

    @Resource
    private DailyTrainTicketService dailyTrainTicketService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainTicketQueryResponse>> queryList(@Valid DailyTrainTicketQueryReq req) {
        PageResp<DailyTrainTicketQueryResponse> queryList = dailyTrainTicketService.queryList(req);
        return new CommonResp<>(queryList);
    }
}
