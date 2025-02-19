package cn.edu.szu.train.business.controller.admin;

import cn.edu.szu.train.common.response.CommonResp;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.business.req.TrainCarriageQueryReq;
import cn.edu.szu.train.business.req.TrainCarriageSaveReq;
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
    public CommonResp<Object> save(@Valid @RequestBody TrainCarriageSaveReq req) {
        trainCarriageService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("query-list")
    public CommonResp<PageResp<TrainCarriageQueryResponse>> queryList(@Valid TrainCarriageQueryReq req) {
        PageResp<TrainCarriageQueryResponse> queryList = trainCarriageService.queryList(req);
        return new CommonResp<>(queryList);
    }

    @DeleteMapping("/delete/{id}")
public CommonResp<Object> delete(@PathVariable Long id) {
        trainCarriageService.delete(id);
        return new CommonResp<>();
    }
}
