package cn.edu.szu.train.business.service;

import cn.edu.szu.train.common.aspect.LogAspect;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.domain.Station;
import cn.edu.szu.train.business.domain.StationExample;
import cn.edu.szu.train.business.mapper.StationMapper;
import cn.edu.szu.train.business.req.StationQueryReq;
import cn.edu.szu.train.business.req.StationSaveReq;
import cn.edu.szu.train.business.response.StationQueryResponse;
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
public class StationService {
private static final Logger LOG = LoggerFactory.getLogger(StationService.class);

@Resource
private StationMapper stationMapper;

public void save(StationSaveReq req) {
DateTime now = DateTime.now();
Station station = BeanUtil.copyProperties(req, Station.class);
if (ObjectUtil.isNull(station.getId())) {
station.setId(SnowUtil.getSnowflakeNextId());
station.setCreateTime(now);
station.setUpdateTime(now);
stationMapper.insert(station);
} else {
station.setUpdateTime(now);
stationMapper.updateByPrimaryKey(station);
}
}

public PageResp<StationQueryResponse> queryList(StationQueryReq req) {
    StationExample stationExample = new StationExample();
    stationExample.setOrderByClause("id desc");
    StationExample.Criteria criteria = stationExample.createCriteria();

    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getPageSize());
    PageHelper.startPage(req.getPage(), req.getPageSize());
    List<Station> stationList = stationMapper.selectByExample(stationExample);

    PageInfo<Station> pageInfo = new PageInfo<>(stationList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<StationQueryResponse> list = BeanUtil.copyToList(stationList, StationQueryResponse.class);

        PageResp<StationQueryResponse> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setRows(list);
            return pageResp;
            }

            public void delete(Long id) {
            stationMapper.deleteByPrimaryKey(id);
            }
}
