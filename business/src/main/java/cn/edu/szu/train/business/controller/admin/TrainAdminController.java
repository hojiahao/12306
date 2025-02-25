package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.business.service.TrainSeatService;
import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.TrainQueryRequest;
import cn.edu.szu.train.business.request.TrainSaveRequest;
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
    public CommonResponse<Object> save(@Valid @RequestBody TrainSaveRequest req) {
        trainService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<TrainQueryResponse>> queryList(@Valid TrainQueryRequest req) {
        PageResponse<TrainQueryResponse> queryList = trainService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        trainService.delete(id);
        return new CommonResponse<>();
    }

    @GetMapping("/query-all")
    public CommonResponse<List<TrainQueryResponse>> queryList() {
        List<TrainQueryResponse> list = trainService.queryAll();
        return new CommonResponse<>(list);
    }

    @GetMapping("/generate-seat/{trainCode}")
    public CommonResponse<Object> generateSeat(@PathVariable String trainCode) {
        trainSeatService.generateTrainSeat(trainCode);
        return new CommonResponse<>();
    }
}
