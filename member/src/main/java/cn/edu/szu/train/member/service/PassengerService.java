package cn.edu.szu.train.member.service;

import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.member.domain.Passenger;
import cn.edu.szu.train.member.domain.PassengerExample;
import cn.edu.szu.train.member.mapper.PassengerMapper;
import cn.edu.szu.train.member.req.PassengerQueryReq;
import cn.edu.szu.train.member.req.PassengerSaveReq;
import cn.edu.szu.train.member.response.PassengerQueryResponse;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

    public List<PassengerQueryResponse> queryList(PassengerQueryReq req) {
        PassengerExample passengerExample = new PassengerExample();
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        if (ObjectUtil.isNotNull(req.getMemberId())){
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        PageHelper.startPage(1, 3);
        List<Passenger> passengers = passengerMapper.selectByExample(passengerExample);
        return BeanUtil.copyToList(passengers, PassengerQueryResponse.class);
    }
}
