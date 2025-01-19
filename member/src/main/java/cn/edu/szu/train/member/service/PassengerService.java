package cn.edu.szu.train.member.service;

import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.member.domain.Passenger;
import cn.edu.szu.train.member.mapper.PassengerMapper;
import cn.edu.szu.train.member.req.PassengerSaveReq;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setMemberId(LoginMemberContext.getId());
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }
}
