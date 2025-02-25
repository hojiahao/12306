package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResponse;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.business.request.TrainStationQueryRequest;
import cn.edu.szu.train.business.request.TrainStationSaveRequest;
import cn.edu.szu.train.business.response.TrainStationQueryResponse;
import cn.edu.szu.train.business.service.TrainStationService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-station")
public class TrainStationAdminController {

    @Resource
    private TrainStationService trainStationService;

    @PostMapping("/save")
    public CommonResponse<Object> save(@Valid @RequestBody TrainStationSaveRequest req) {
        trainStationService.save(req);
        return new CommonResponse<>();
    }

    @GetMapping("/query-list")
    public CommonResponse<PageResponse<TrainStationQueryResponse>> queryList(@Valid TrainStationQueryRequest req) {
        PageResponse<TrainStationQueryResponse> queryList = trainStationService.queryList(req);
        return new CommonResponse<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse<Object> delete(@PathVariable Long id) {
        trainStationService.delete(id);
        return new CommonResponse<>();
    }
}
