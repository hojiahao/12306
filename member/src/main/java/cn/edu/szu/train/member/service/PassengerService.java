package cn.edu.szu.train.member.service;

import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.member.domain.Member;
import cn.edu.szu.train.member.domain.MemberExample;
import cn.edu.szu.train.member.domain.Passenger;
import cn.edu.szu.train.member.domain.PassengerExample;
import cn.edu.szu.train.member.enums.PassengerTypeEnum;
import cn.edu.szu.train.member.mapper.MemberMapper;
import cn.edu.szu.train.member.mapper.PassengerMapper;
import cn.edu.szu.train.member.request.PassengerQueryRequest;
import cn.edu.szu.train.member.request.PassengerSaveRequest;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PassengerService {
    private static final Logger LOG = LoggerFactory.getLogger(PassengerService.class);

    @Resource
    private PassengerMapper passengerMapper;

    @Resource
    private MemberMapper memberMapper;

    public void save(PassengerSaveRequest req) {
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

    public PageResponse<PassengerQueryResponse> queryList(PassengerQueryRequest req) {
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

        PageResponse<PassengerQueryResponse> pageResponse = new PageResponse<>();
        pageResponse.setTotal(pageInfo.getTotal());
        pageResponse.setRows(list);
        return pageResponse;
    }

    public void delete(Long id) {
        passengerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询我的常旅客列表中全部乘客
     */
    public List<PassengerQueryResponse> queryMine() {
        PassengerExample passengerExample = new PassengerExample();
        passengerExample.setOrderByClause("name asc");
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        criteria.andMemberIdEqualTo(LoginMemberContext.getId());
        List<Passenger> passengers = passengerMapper.selectByExample(passengerExample);
        return BeanUtil.copyToList(passengers, PassengerQueryResponse.class);
    }

    /**
     * 初始化乘客，如果没有张三，就增加乘客张三，李四、王五同理，防止线上体验时乘客被删光
     */
    public void init() {
        DateTime now = DateTime.now();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo("13000000000");
        List<Member> members = memberMapper.selectByExample(memberExample);
        Member member = members.get(0);
        List<Passenger> passengerList = new ArrayList<>();
        List<String> nameList = Arrays.asList("张三", "李四", "王五");
        for (String name : nameList) {
            Passenger passenger = new Passenger();
            passenger.setId(SnowUtil.getSnowflakeNextId());
            passenger.setMemberId(member.getId());
            passenger.setName(name);
            passenger.setIdCard("123456789123456789");
            passenger.setType(PassengerTypeEnum.ADULT.getCode());
            passenger.setCreateTime(now);
            passenger.setUpdateTime(now);
            passengerList.add(passenger);
        }
        for (Passenger passenger : passengerList) {
            PassengerExample passengerExample = new PassengerExample();
            passengerExample.createCriteria().andNameEqualTo(passenger.getName());
            long l = passengerMapper.countByExample(passengerExample);
            if (l == 0) {
                passengerMapper.insert(passenger);
            }
        }
    }
}
