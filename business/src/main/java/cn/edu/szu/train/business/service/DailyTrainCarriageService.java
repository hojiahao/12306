package cn.edu.szu.train.business.service;

import cn.edu.szu.train.common.aspect.LogAspect;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.domain.DailyTrainCarriage;
import cn.edu.szu.train.business.domain.DailyTrainCarriageExample;
import cn.edu.szu.train.business.mapper.DailyTrainCarriageMapper;
import cn.edu.szu.train.business.req.DailyTrainCarriageQueryReq;
import cn.edu.szu.train.business.req.DailyTrainCarriageSaveReq;
import cn.edu.szu.train.business.response.DailyTrainCarriageQueryResponse;
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
public class DailyTrainCarriageService {
private static final Logger LOG = LoggerFactory.getLogger(DailyTrainCarriageService.class);

@Resource
private DailyTrainCarriageMapper dailyTrainCarriageMapper;

public void save(DailyTrainCarriageSaveReq req) {
DateTime now = DateTime.now();
DailyTrainCarriage dailyTrainCarriage = BeanUtil.copyProperties(req, DailyTrainCarriage.class);
if (ObjectUtil.isNull(dailyTrainCarriage.getId())) {
dailyTrainCarriage.setId(SnowUtil.getSnowflakeNextId());
dailyTrainCarriage.setCreateTime(now);
dailyTrainCarriage.setUpdateTime(now);
dailyTrainCarriageMapper.insert(dailyTrainCarriage);
} else {
dailyTrainCarriage.setUpdateTime(now);
dailyTrainCarriageMapper.updateByPrimaryKey(dailyTrainCarriage);
}
}

public PageResp<DailyTrainCarriageQueryResponse> queryList(DailyTrainCarriageQueryReq req) {
    DailyTrainCarriageExample dailyTrainCarriageExample = new DailyTrainCarriageExample();
    dailyTrainCarriageExample.setOrderByClause("id desc");
    DailyTrainCarriageExample.Criteria criteria = dailyTrainCarriageExample.createCriteria();

    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getPageSize());
    PageHelper.startPage(req.getPage(), req.getPageSize());
    List<DailyTrainCarriage> dailyTrainCarriageList = dailyTrainCarriageMapper.selectByExample(dailyTrainCarriageExample);

    PageInfo<DailyTrainCarriage> pageInfo = new PageInfo<>(dailyTrainCarriageList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<DailyTrainCarriageQueryResponse> list = BeanUtil.copyToList(dailyTrainCarriageList, DailyTrainCarriageQueryResponse.class);

        PageResp<DailyTrainCarriageQueryResponse> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setRows(list);
            return pageResp;
            }

            public void delete(Long id) {
            dailyTrainCarriageMapper.deleteByPrimaryKey(id);
            }
}
