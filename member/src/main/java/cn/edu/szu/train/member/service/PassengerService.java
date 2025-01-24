package cn.edu.szu.train.member.service;

import cn.edu.szu.train.common.aspect.LogAspect;
import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.response.PageResp;
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
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final static Logger LOG = LoggerFactory.getLogger(PassengerService.class);

    @Resource
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        if (ObjectUtil.isNull(passenger.getId())) {
            passenger.setMemberId(LoginMemberContext.getId());
            passenger.setId(SnowUtil.getSnowflakeNextId());
            passenger.setCreateTime(now);
            passenger.setUpdateTime(now);
            passengerMapper.insert(passenger);
        }
        else {
            passenger.setUpdateTime(now);
            passengerMapper.updateByPrimaryKey(passenger);
        }
    }

    public PageResp<PassengerQueryResponse> queryList(PassengerQueryReq req) {
        PassengerExample passengerExample = new PassengerExample();
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        if (ObjectUtil.isNotNull(req.getMemberId())){
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        LOG.info("query page number: {}", req.getPage());
        LOG.info("items per page: {}", req.getPageSize());
        PageHelper.startPage(req.getPage(), req.getPageSize());
        List<Passenger> passengers = passengerMapper.selectByExample(passengerExample);
        PageInfo<Passenger> pageInfo = new PageInfo<>(passengers);
        LOG.info("total rows: {}", pageInfo.getTotal());
        LOG.info("total pages: {}", pageInfo.getPages());
        List<PassengerQueryResponse> list = BeanUtil.copyToList(passengers, PassengerQueryResponse.class);
        PageResp<PassengerQueryResponse> pageResp = new PageResp<>();
        pageResp.setRows(list);
        pageResp.setTotal(pageInfo.getTotal());
        return pageResp;
    }
}
