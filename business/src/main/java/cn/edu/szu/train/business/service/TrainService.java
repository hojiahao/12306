package cn.edu.szu.train.business.service;

import cn.edu.szu.train.common.aspect.LogAspect;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.domain.Train;
import cn.edu.szu.train.business.domain.TrainExample;
import cn.edu.szu.train.business.mapper.TrainMapper;
import cn.edu.szu.train.business.req.TrainQueryReq;
import cn.edu.szu.train.business.req.TrainSaveReq;
import cn.edu.szu.train.business.response.TrainQueryResponse;
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
public class TrainService {
    private static final Logger LOG = LoggerFactory.getLogger(TrainService.class);

    @Resource
    private TrainMapper trainMapper;

    public void save(TrainSaveReq req) {
        DateTime now = DateTime.now();
        Train train = BeanUtil.copyProperties(req, Train.class);
        if (ObjectUtil.isNull(train.getId())) {
            train.setId(SnowUtil.getSnowflakeNextId());
            train.setCreateTime(now);
            train.setUpdateTime(now);
            trainMapper.insert(train);
        } else {
        train.setUpdateTime(now);
        trainMapper.updateByPrimaryKey(train);
        }
    }

    public PageResp<TrainQueryResponse> queryList(TrainQueryReq req) {
        TrainExample trainExample = new TrainExample();
        trainExample.setOrderByClause("id desc");
        TrainExample.Criteria criteria = trainExample.createCriteria();

        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getPageSize());
        PageHelper.startPage(req.getPage(), req.getPageSize());
        List<Train> trainList = trainMapper.selectByExample(trainExample);

        PageInfo<Train> pageInfo = new PageInfo<>(trainList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<TrainQueryResponse> list = BeanUtil.copyToList(trainList, TrainQueryResponse.class);

        PageResp<TrainQueryResponse> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setRows(list);
        return pageResp;
    }

    public void delete(Long id) {
        trainMapper.deleteByPrimaryKey(id);
    }

    public List<TrainQueryResponse> queryAll() {
        TrainExample trainExample = new TrainExample();
        trainExample.setOrderByClause("code desc");
        List<Train> trainList = trainMapper.selectByExample(trainExample);
        return BeanUtil.copyToList(trainList, TrainQueryResponse.class);
    }
}
