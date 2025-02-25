package cn.edu.szu.train.member.controller.admin;

import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.member.req.TicketQueryReq;
import cn.edu.szu.train.member.req.TicketSaveReq;
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
    public CommonResp<PageResp<TicketQueryResponse>> queryList(@Valid TicketQueryReq req) {
        PageResp<TicketQueryResponse> list = ticketService.queryList(req);
        return new CommonResp<>(list);
    }
}
