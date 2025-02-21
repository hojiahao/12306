package cn.edu.szu.train.business.service;

import cn.edu.szu.train.common.aspect.LogAspect;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.domain.DailyTrainStation;
import cn.edu.szu.train.business.domain.DailyTrainStationExample;
import cn.edu.szu.train.business.mapper.DailyTrainStationMapper;
import cn.edu.szu.train.business.req.DailyTrainStationQueryReq;
import cn.edu.szu.train.business.req.DailyTrainStationSaveReq;
import cn.edu.szu.train.business.response.DailyTrainStationQueryResponse;
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
public class DailyTrainStationService {
private static final Logger LOG = LoggerFactory.getLogger(DailyTrainStationService.class);

@Resource
private DailyTrainStationMapper dailyTrainStationMapper;

public void save(DailyTrainStationSaveReq req) {
DateTime now = DateTime.now();
DailyTrainStation dailyTrainStation = BeanUtil.copyProperties(req, DailyTrainStation.class);
if (ObjectUtil.isNull(dailyTrainStation.getId())) {
dailyTrainStation.setId(SnowUtil.getSnowflakeNextId());
dailyTrainStation.setCreateTime(now);
dailyTrainStation.setUpdateTime(now);
dailyTrainStationMapper.insert(dailyTrainStation);
} else {
dailyTrainStation.setUpdateTime(now);
dailyTrainStationMapper.updateByPrimaryKey(dailyTrainStation);
}
}

public PageResp<DailyTrainStationQueryResponse> queryList(DailyTrainStationQueryReq req) {
    DailyTrainStationExample dailyTrainStationExample = new DailyTrainStationExample();
    dailyTrainStationExample.setOrderByClause("id desc");
    DailyTrainStationExample.Criteria criteria = dailyTrainStationExample.createCriteria();

    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getPageSize());
    PageHelper.startPage(req.getPage(), req.getPageSize());
    List<DailyTrainStation> dailyTrainStationList = dailyTrainStationMapper.selectByExample(dailyTrainStationExample);

    PageInfo<DailyTrainStation> pageInfo = new PageInfo<>(dailyTrainStationList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<DailyTrainStationQueryResponse> list = BeanUtil.copyToList(dailyTrainStationList, DailyTrainStationQueryResponse.class);

        PageResp<DailyTrainStationQueryResponse> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setRows(list);
            return pageResp;
            }

            public void delete(Long id) {
            dailyTrainStationMapper.deleteByPrimaryKey(id);
            }
}
