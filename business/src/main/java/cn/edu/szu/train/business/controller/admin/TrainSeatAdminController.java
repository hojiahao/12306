package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.TrainSeatQueryRequest;
import cn.edu.szu.train.business.request.TrainSeatSaveRequest;
import cn.edu.szu.train.business.response.TrainSeatQueryResponse;
import cn.edu.szu.train.business.service.TrainSeatService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-seat")
public class TrainSeatAdminController {

    @Resource
    private TrainSeatService trainSeatService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody TrainSeatSaveRequest req) {
        trainSeatService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<TrainSeatQueryResponse>> queryList(@Valid TrainSeatQueryRequest req) {
        PageResponse<TrainSeatQueryResponse> queryList = trainSeatService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        trainSeatService.delete(id);
        return new CommonResponse<>();
    }
}
