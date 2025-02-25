package cn.edu.szu.train.batch.feign;

import cn.edu.szu.train.common.response.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@FeignClient("business")
//@FeignClient(name = "business", url = "http://127.0.0.1:8002/business")
public interface BusinessFeign {
    @GetMapping("/business/hello")
    String hello();

    @GetMapping("/business/admin/daily-train/generate-daily-train/{date}")
    CommonResponse<Object> generateDailyTrain(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date);
}
