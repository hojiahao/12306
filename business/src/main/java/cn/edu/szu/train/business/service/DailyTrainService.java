package cn.edu.szu.train.business.service;

import cn.edu.szu.train.common.aspect.LogAspect;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.domain.DailyTrain;
import cn.edu.szu.train.business.domain.DailyTrainExample;
import cn.edu.szu.train.business.mapper.DailyTrainMapper;
import cn.edu.szu.train.business.req.DailyTrainQueryReq;
import cn.edu.szu.train.business.req.DailyTrainSaveReq;
import cn.edu.szu.train.business.response.DailyTrainQueryResponse;
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
public class DailyTrainService {
private static final Logger LOG = LoggerFactory.getLogger(DailyTrainService.class);

@Resource
private DailyTrainMapper dailyTrainMapper;

public void save(DailyTrainSaveReq req) {
DateTime now = DateTime.now();
DailyTrain dailyTrain = BeanUtil.copyProperties(req, DailyTrain.class);
if (ObjectUtil.isNull(dailyTrain.getId())) {
dailyTrain.setId(SnowUtil.getSnowflakeNextId());
dailyTrain.setCreateTime(now);
dailyTrain.setUpdateTime(now);
dailyTrainMapper.insert(dailyTrain);
} else {
dailyTrain.setUpdateTime(now);
dailyTrainMapper.updateByPrimaryKey(dailyTrain);
}
}

public PageResp<DailyTrainQueryResponse> queryList(DailyTrainQueryReq req) {
    DailyTrainExample dailyTrainExample = new DailyTrainExample();
    dailyTrainExample.setOrderByClause("id desc");
    DailyTrainExample.Criteria criteria = dailyTrainExample.createCriteria();

    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getPageSize());
    PageHelper.startPage(req.getPage(), req.getPageSize());
    List<DailyTrain> dailyTrainList = dailyTrainMapper.selectByExample(dailyTrainExample);

    PageInfo<DailyTrain> pageInfo = new PageInfo<>(dailyTrainList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<DailyTrainQueryResponse> list = BeanUtil.copyToList(dailyTrainList, DailyTrainQueryResponse.class);

        PageResp<DailyTrainQueryResponse> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setRows(list);
            return pageResp;
            }

            public void delete(Long id) {
            dailyTrainMapper.deleteByPrimaryKey(id);
            }
}
