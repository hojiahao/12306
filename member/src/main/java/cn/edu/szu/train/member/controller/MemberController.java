package cn.edu.szu.train.member.controller;

import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.member.req.MemberLoginReq;
import cn.edu.szu.train.member.req.MemberRegisterReq;
import cn.edu.szu.train.member.req.MemberSendCodeReq;
import cn.edu.szu.train.member.response.MemberLoginResponse;
import cn.edu.szu.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count() {
        int count = memberService.count();
        CommonResp<Integer> commonResp = new CommonResp<>();
        commonResp.setContent(count);
        return commonResp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req) {
        long register = memberService.register(req);
//        CommonResp<Long> commonResp = new CommonResp<>();
//        commonResp.setContent(register);
        return new CommonResp<>(register);
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid MemberSendCodeReq req) throws Exception {
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResponse> sendCode(@Valid MemberLoginReq req) {
        MemberLoginResponse loginResponse = memberService.login(req);
        return new CommonResp<>(loginResponse);
    }
}
