package cn.edu.szu.train.member.controller;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.member.request.MemberLoginRequest;
import cn.edu.szu.train.member.request.MemberRegisterRequest;
import cn.edu.szu.train.member.request.MemberSendCodeRequest;
import cn.edu.szu.train.member.response.MemberLoginResponse;
import cn.edu.szu.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResponse<Integer> count() {
        int count = memberService.count();
        CommonResponse<Integer> commonResponse = new CommonResponse<>();
        commonResponse.setContent(count);
        return commonResponse;
    }

    @PostMapping("/register")
    public CommonResponse<Long> register(@Valid MemberRegisterRequest req) {
        long register = memberService.register(req);
//        CommonResp<Long> commonResp = new CommonResp<>();
//        commonResp.setContent(register);
        return new CommonResponse<>(register);
    }

    @PostMapping("/send-code")
    public CommonResponse<Long> sendCode(@Valid @RequestBody MemberSendCodeRequest req) throws Exception {
        memberService.sendCode(req);
        return new CommonResponse<>();
    }

    @PostMapping("/login")
    public CommonResponse<MemberLoginResponse> sendCode(@Valid @RequestBody MemberLoginRequest req) {
        MemberLoginResponse loginResponse = memberService.login(req);
        return new CommonResponse<>(loginResponse);
    }
}
