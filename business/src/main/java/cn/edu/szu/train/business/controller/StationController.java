package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.response.StationQueryResponse;
import cn.edu.szu.train.business.service.StationService;
import cn.edu.szu.train.common.response.CommonResp;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {

    @Resource
    private StationService stationService;

    @GetMapping("/query-all")
    public CommonResp<List<StationQueryResponse>> queryAll() {
        List<StationQueryResponse> list = stationService.queryAll();
        return new CommonResp<>(list);
    }
}
