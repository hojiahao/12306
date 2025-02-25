package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.request.DailyTrainTicketQueryRequest;
import cn.edu.szu.train.business.response.DailyTrainTicketQueryResponse;
import cn.edu.szu.train.business.service.DailyTrainTicketService;
import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/daily-train-ticket")
public class DailyTrainTicketController {

    @Resource
    private DailyTrainTicketService dailyTrainTicketService;

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<DailyTrainTicketQueryResponse>> queryList(@Valid DailyTrainTicketQueryRequest req) {
        PageResponse<DailyTrainTicketQueryResponse> queryList = dailyTrainTicketService.queryList(req);
        return new CommonResponse<>(queryList);
    }
}
