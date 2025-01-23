package cn.edu.szu.train.member.controller;

import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.member.req.PassengerQueryReq;
import cn.edu.szu.train.member.req.PassengerSaveReq;
import cn.edu.szu.train.member.response.PassengerQueryResponse;
import cn.edu.szu.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Resource
    private PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req) {
        passengerService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("query-list")
    public CommonResp<List<PassengerQueryResponse>> queryList(@Valid PassengerQueryReq req) {
        List<PassengerQueryResponse> queryList = passengerService.queryList(req);
        return new CommonResp<>(queryList);
    }
}
