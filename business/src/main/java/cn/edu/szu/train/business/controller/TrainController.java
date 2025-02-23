package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.response.TrainQueryResponse;
import cn.edu.szu.train.business.service.TrainService;
import cn.edu.szu.train.common.response.CommonResp;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Resource
    private TrainService trainService;

    @GetMapping("/query-all")
    public CommonResp<List<TrainQueryResponse>> queryList() {
        List<TrainQueryResponse> list = trainService.queryAll();
        return new CommonResp<>(list);
    }
}
