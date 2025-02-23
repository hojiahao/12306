package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.business.service.TrainSeatService;
import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.business.req.TrainQueryReq;
import cn.edu.szu.train.business.req.TrainSaveReq;
import cn.edu.szu.train.business.response.TrainQueryResponse;
import cn.edu.szu.train.business.service.TrainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/train")
public class TrainAdminController {

    @Resource
    private TrainService trainService;

    @Resource
    private TrainSeatService trainSeatService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody TrainSaveReq req) {
        trainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainQueryResponse>> queryList(@Valid TrainQueryReq req) {
        PageResp<TrainQueryResponse> queryList = trainService.queryList(req);
        return new CommonResp<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        trainService.delete(id);
        return new CommonResp<>();
    }

    @GetMapping("/query-all")
    public CommonResp<List<TrainQueryResponse>> queryList() {
        List<TrainQueryResponse> list = trainService.queryAll();
        return new CommonResp<>(list);
    }

    @GetMapping("/generate-seat/{trainCode}")
    public CommonResp<Object> generateSeat(@PathVariable String trainCode) {
        trainSeatService.generateTrainSeat(trainCode);
        return new CommonResp<>();
    }
}
