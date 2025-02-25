package cn.edu.szu.train.business.feign;

import cn.edu.szu.train.common.request.MemberTicketRequest;
import cn.edu.szu.train.common.response.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

 @FeignClient("member")
//@FeignClient(name = "member", url = "http://127.0.0.1:8001")
public interface MemberFeign {

    @GetMapping("/member/feign/ticket/save")
    CommonResponse<Object> save(@RequestBody MemberTicketRequest req);

}
