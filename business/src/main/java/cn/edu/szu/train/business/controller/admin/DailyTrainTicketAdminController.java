package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.DailyTrainTicketQueryRequest;
import cn.edu.szu.train.business.request.DailyTrainTicketSaveRequest;
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
    public CommonResponse<Object> save(@Valid @RequestBody DailyTrainTicketSaveRequest req) {
        dailyTrainTicketService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<DailyTrainTicketQueryResponse>> queryList(@Valid DailyTrainTicketQueryRequest req) {
        PageResponse<DailyTrainTicketQueryResponse> queryList = dailyTrainTicketService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @GetMapping("/query-list2")
    public CommonResponse<PageResponse<DailyTrainTicketQueryResponse>> queryList2(@Valid DailyTrainTicketQueryRequest req) {
        PageResponse<DailyTrainTicketQueryResponse> queryList = dailyTrainTicketService.queryList2(req);
        return new CommonResponse<>(queryList);
    }

    @GetMapping("/query-list3")
    public CommonResponse<PageResponse<DailyTrainTicketQueryResponse>> queryList3(@Valid DailyTrainTicketQueryRequest req) {
        PageResponse<DailyTrainTicketQueryResponse> queryList = dailyTrainTicketService.queryList3(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        dailyTrainTicketService.delete(id);
        return new CommonResponse<>();
    }
}
