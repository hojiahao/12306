package cn.edu.szu.train.member.controller;

import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.member.request.TicketQueryRequest;
import cn.edu.szu.train.member.response.TicketQueryResponse;
import cn.edu.szu.train.member.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<TicketQueryResponse>> query(@Valid TicketQueryRequest req) {
        CommonResponse<PageResponse<TicketQueryResponse>> commonResponse = new CommonResponse<>();
        req.setMemberId(LoginMemberContext.getId());
        PageResponse<TicketQueryResponse> pageResponse = ticketService.queryList(req);
        commonResponse.setContent(pageResponse);
        return commonResponse;
    }

}
