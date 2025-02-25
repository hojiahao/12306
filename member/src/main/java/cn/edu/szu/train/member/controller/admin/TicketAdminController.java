package cn.edu.szu.train.member.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.member.request.TicketQueryRequest;
import cn.edu.szu.train.member.response.TicketQueryResponse;
import cn.edu.szu.train.member.service.TicketService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/ticket")
public class TicketAdminController {

    @Resource
    private TicketService ticketService;

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<TicketQueryResponse>> queryList(@Valid TicketQueryRequest req) {
        PageResponse<TicketQueryResponse> list = ticketService.queryList(req);
        return new CommonResponse<>(list);
    }
}
