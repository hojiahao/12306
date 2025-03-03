package cn.edu.szu.train.business.controller;

import cn.edu.szu.train.business.request.SeatSellRequest;
import cn.edu.szu.train.business.response.SeatSellResponse;
import cn.edu.szu.train.business.service.DailyTrainSeatService;
import cn.edu.szu.train.common.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("seat-sell")
public class SeatSellController {
    @Autowired
    private DailyTrainSeatService dailyTrainSeatService;

    @GetMapping("/query")
    public CommonResponse<List<SeatSellResponse>> query(@Validated SeatSellRequest request){
        List<SeatSellResponse> seatSellList = dailyTrainSeatService.querySeatSell(request);
        return new CommonResponse<>(seatSellList);
    }
}
