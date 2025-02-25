package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.TrainCarriageQueryRequest;
import cn.edu.szu.train.business.request.TrainCarriageSaveRequest;
import cn.edu.szu.train.business.response.TrainCarriageQueryResponse;
import cn.edu.szu.train.business.service.TrainCarriageService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-carriage")
public class TrainCarriageAdminController {

    @Resource
    private TrainCarriageService trainCarriageService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody TrainCarriageSaveRequest req) {
        trainCarriageService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<TrainCarriageQueryResponse>> queryList(@Valid TrainCarriageQueryRequest req) {
        PageResponse<TrainCarriageQueryResponse> queryList = trainCarriageService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        trainCarriageService.delete(id);
        return new CommonResponse<>();
    }
}
