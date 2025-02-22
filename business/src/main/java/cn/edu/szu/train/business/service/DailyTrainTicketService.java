package cn.edu.szu.train.business.service;

import cn.edu.szu.train.common.aspect.LogAspect;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.domain.DailyTrainTicket;
import cn.edu.szu.train.business.domain.DailyTrainTicketExample;
import cn.edu.szu.train.business.mapper.DailyTrainTicketMapper;
import cn.edu.szu.train.business.req.DailyTrainTicketQueryReq;
import cn.edu.szu.train.business.req.DailyTrainTicketSaveReq;
import cn.edu.szu.train.business.response.DailyTrainTicketQueryResponse;
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
public class DailyTrainTicketService {
private static final Logger LOG = LoggerFactory.getLogger(DailyTrainTicketService.class);

@Resource
private DailyTrainTicketMapper dailyTrainTicketMapper;

public void save(DailyTrainTicketSaveReq req) {
DateTime now = DateTime.now();
DailyTrainTicket dailyTrainTicket = BeanUtil.copyProperties(req, DailyTrainTicket.class);
if (ObjectUtil.isNull(dailyTrainTicket.getId())) {
dailyTrainTicket.setId(SnowUtil.getSnowflakeNextId());
dailyTrainTicket.setCreateTime(now);
dailyTrainTicket.setUpdateTime(now);
dailyTrainTicketMapper.insert(dailyTrainTicket);
} else {
dailyTrainTicket.setUpdateTime(now);
dailyTrainTicketMapper.updateByPrimaryKey(dailyTrainTicket);
}
}

public PageResp<DailyTrainTicketQueryResponse> queryList(DailyTrainTicketQueryReq req) {
    DailyTrainTicketExample dailyTrainTicketExample = new DailyTrainTicketExample();
    dailyTrainTicketExample.setOrderByClause("id desc");
    DailyTrainTicketExample.Criteria criteria = dailyTrainTicketExample.createCriteria();

    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getPageSize());
    PageHelper.startPage(req.getPage(), req.getPageSize());
    List<DailyTrainTicket> dailyTrainTicketList = dailyTrainTicketMapper.selectByExample(dailyTrainTicketExample);

    PageInfo<DailyTrainTicket> pageInfo = new PageInfo<>(dailyTrainTicketList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<DailyTrainTicketQueryResponse> list = BeanUtil.copyToList(dailyTrainTicketList, DailyTrainTicketQueryResponse.class);

        PageResp<DailyTrainTicketQueryResponse> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setRows(list);
            return pageResp;
            }

            public void delete(Long id) {
            dailyTrainTicketMapper.deleteByPrimaryKey(id);
            }
}
