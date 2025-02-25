package cn.edu.szu.train.member.feign;

import cn.edu.szu.train.common.request.MemberTicketRequest;
import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.member.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/ticket")
public class FeignTicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody MemberTicketRequest req) {
        ticketService.save(req);
        return new CommonResp<>();
    }
}
