package cn.edu.szu.train.batch.feign;

import cn.edu.szu.train.common.response.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BusinessFeignFallback implements BusinessFeign{
    @Override
    public String hello() {
        return "FallBack";
    }

    @Override
    public CommonResponse<Object> generateDailyTrain(Date date) {
        return null;
    }
}
