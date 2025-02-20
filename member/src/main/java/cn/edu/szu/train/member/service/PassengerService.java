package cn.edu.szu.train.member.service;

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
private static final Logger LOG = LoggerFactory.getLogger(PassengerService.class);

@Resource
private PassengerMapper passengerMapper;

public void save(PassengerSaveReq req) {
DateTime now = DateTime.now();
Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
if (ObjectUtil.isNull(passenger.getId())) {
passenger.setId(SnowUtil.getSnowflakeNextId());
passenger.setCreateTime(now);
passenger.setUpdateTime(now);
passengerMapper.insert(passenger);
} else {
passenger.setUpdateTime(now);
passengerMapper.updateByPrimaryKey(passenger);
}
}

public PageResp<PassengerQueryResponse> queryList(PassengerQueryReq req) {
    PassengerExample passengerExample = new PassengerExample();
    passengerExample.setOrderByClause("id desc");
    PassengerExample.Criteria criteria = passengerExample.createCriteria();

    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getPageSize());
    PageHelper.startPage(req.getPage(), req.getPageSize());
    List<Passenger> passengerList = passengerMapper.selectByExample(passengerExample);

    PageInfo<Passenger> pageInfo = new PageInfo<>(passengerList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<PassengerQueryResponse> list = BeanUtil.copyToList(passengerList, PassengerQueryResponse.class);

        PageResp<PassengerQueryResponse> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setRows(list);
            return pageResp;
            }

            public void delete(Long id) {
            passengerMapper.deleteByPrimaryKey(id);
            }
}
