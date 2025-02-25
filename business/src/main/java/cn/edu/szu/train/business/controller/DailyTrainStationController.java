package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.request.DailyTrainStationQueryAllRequest;
import cn.edu.szu.train.business.response.DailyTrainStationQueryResponse;
import cn.edu.szu.train.business.service.DailyTrainStationService;
import cn.edu.szu.train.common.response.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/daily-train-station")
public class DailyTrainStationController {

    @Autowired
    private DailyTrainStationService dailyTrainStationService;

    @GetMapping("/query-by-train-code")
    public CommonResponse<List<DailyTrainStationQueryResponse>> queryByTrain(@Valid DailyTrainStationQueryAllRequest req) {
        List<DailyTrainStationQueryResponse> list = dailyTrainStationService.queryByTrain(req.getDate(), req.getTrainCode());
        return new CommonResponse<>(list);
    }

}
