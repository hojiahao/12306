package cn.edu.szu.train.member.controller;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.member.request.PassengerQueryRequest;
import cn.edu.szu.train.member.request.PassengerSaveRequest;
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
    public CommonResponse<Object> save(@Valid @RequestBody PassengerSaveRequest req) {
        passengerService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("query-list")
    public CommonResponse<PageResponse<PassengerQueryResponse>> queryList(@Valid PassengerQueryRequest req) {
        PageResponse<PassengerQueryResponse> queryList = passengerService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
public CommonResponse<Object> delete(@PathVariable Long id) {
        passengerService.delete(id);
        return new CommonResponse<>();
    }

    @GetMapping("/query-mine")
    public CommonResponse<List<PassengerQueryResponse>> queryMine() {
        List<PassengerQueryResponse> list = passengerService.queryMine();
        return new CommonResponse<>(list);
    }

    @GetMapping("/init")
    public CommonResponse<Object> init() {
        passengerService.init();
        return new CommonResponse<>();
    }
}
