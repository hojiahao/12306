package cn.edu.szu.train.member.service;

import cn.edu.szu.train.common.request.MemberTicketRequest;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.member.domain.Ticket;
import cn.edu.szu.train.member.domain.TicketExample;
import cn.edu.szu.train.member.mapper.TicketMapper;
import cn.edu.szu.train.member.request.TicketQueryRequest;
import cn.edu.szu.train.member.response.TicketQueryResponse;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private static final Logger LOG = LoggerFactory.getLogger(TicketService.class);

    @Resource
    private TicketMapper ticketMapper;

    /**
     * 会员购买车票后新增保存
     * @param req
     */
    public void save(MemberTicketRequest req) {
        // LOG.info("seata全局事务ID save: {}", RootContext.getXID());
        DateTime now = DateTime.now();
        Ticket ticket = BeanUtil.copyProperties(req, Ticket.class);
        ticket.setId(SnowUtil.getSnowflakeNextId());
        ticket.setCreateTime(now);
        ticket.setUpdateTime(now);
        ticketMapper.insert(ticket);
        // 模拟被调用方出现异常
        // if (1 == 1) {
        //     throw new Exception("测试异常11");
        // }
    }

    public PageResponse<TicketQueryResponse> queryList(TicketQueryRequest req) {
        TicketExample ticketExample = new TicketExample();
        ticketExample.setOrderByClause("id desc");
        TicketExample.Criteria criteria = ticketExample.createCriteria();

        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getPageSize());
        PageHelper.startPage(req.getPage(), req.getPageSize());
        List<Ticket> ticketList = ticketMapper.selectByExample(ticketExample);

        PageInfo<Ticket> pageInfo = new PageInfo<>(ticketList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<TicketQueryResponse> list = BeanUtil.copyToList(ticketList, TicketQueryResponse.class);

        PageResponse<TicketQueryResponse> pageResponse = new PageResponse<>();
        pageResponse.setTotal(pageInfo.getTotal());
        pageResponse.setRows(list);
        return pageResponse;
    }

    public void delete(Long id) {
        ticketMapper.deleteByPrimaryKey(id);
    }
}
