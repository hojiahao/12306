package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.response.TrainQueryResponse;
import cn.edu.szu.train.business.service.TrainService;
import cn.edu.szu.train.common.response.CommonResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Resource
    private TrainService trainService;

    @GetMapping("/query-all")
    public CommonResponse<List<TrainQueryResponse>> queryList() {
        List<TrainQueryResponse> list = trainService.queryAll();
        return new CommonResponse<>(list);
    }
}
