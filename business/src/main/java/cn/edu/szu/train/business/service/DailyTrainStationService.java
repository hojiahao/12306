package cn.edu.szu.train.business.service;

import cn.edu.szu.train.business.domain.TrainStation;
import cn.edu.szu.train.business.mapper.TrainStationMapper;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.domain.DailyTrainStation;
import cn.edu.szu.train.business.domain.DailyTrainStationExample;
import cn.edu.szu.train.business.mapper.DailyTrainStationMapper;
import cn.edu.szu.train.business.req.DailyTrainStationQueryReq;
import cn.edu.szu.train.business.req.DailyTrainStationSaveReq;
import cn.edu.szu.train.business.response.DailyTrainStationQueryResponse;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DailyTrainStationService {
    private static final Logger LOG = LoggerFactory.getLogger(DailyTrainStationService.class);

    @Resource
    private TrainStationMapper trainStationMapper;

    @Resource
    private DailyTrainStationMapper dailyTrainStationMapper;
    @Autowired
    private TrainStationService trainStationService;

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
        dailyTrainStationExample.setOrderByClause("date desc, train_code asc, `index` asc");
        DailyTrainStationExample.Criteria criteria = dailyTrainStationExample.createCriteria();
        if (ObjectUtil.isNotNull(req.getDate())) {
            criteria.andDateEqualTo(req.getDate());
        }
        if (ObjectUtil.isNotEmpty(req.getTrainCode())) {
            criteria.andTrainCodeEqualTo(req.getTrainCode());
        }

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

    @Transactional
    public void generateDailyTrainStation(Date date, String trainCode) {
        LOG.info("开始生成日期【{}】车次【{}】的车站信息...", DateUtil.formatDate(date), trainCode);
        // 删除某日某车次的车站信息
        DailyTrainStationExample dailyTrainStationExample = new DailyTrainStationExample();
        dailyTrainStationExample.createCriteria().andDateEqualTo(date).andTrainCodeEqualTo(trainCode);
        dailyTrainStationMapper.deleteByExample(dailyTrainStationExample);

        // 查出某车次所有的车站信息
        List<TrainStation> trainStations = trainStationService.selectByTrainCode(trainCode);
        if (CollUtil.isEmpty(trainStations)) {
            LOG.info("未找到车站基础数据，生成任务结束。");
            return;
        }
        for (TrainStation trainStation : trainStations) {
            DateTime now = DateTime.now();
            DailyTrainStation dailyTrainStation = BeanUtil.copyProperties(trainStation, DailyTrainStation.class);
            dailyTrainStation.setId(SnowUtil.getSnowflakeNextId());
            dailyTrainStation.setCreateTime(now);
            dailyTrainStation.setUpdateTime(now);
            dailyTrainStation.setDate(date);
            dailyTrainStation.setKm(trainStation.getKilometers());
            dailyTrainStationMapper.insert(dailyTrainStation);
        }
        LOG.info("日期【{}】车次【{}】的车站信息已生成完成。", DateUtil.formatDate(date), trainCode);
    }

    /**
     * 按车次查询全部车站
     */
    public long countByTrainCode(Date date, String trainCode) {
        DailyTrainStationExample example = new DailyTrainStationExample();
        example.createCriteria().andDateEqualTo(date).andTrainCodeEqualTo(trainCode);
        return dailyTrainStationMapper.countByExample(example);
    }

    /**
     * 按车次日期查询车站列表，用于界面显示一列车经过的车站
     */
    public List<DailyTrainStationQueryResponse> queryByTrain(Date date, String trainCode) {
        DailyTrainStationExample dailyTrainStationExample = new DailyTrainStationExample();
        dailyTrainStationExample.setOrderByClause("`index` asc");
        dailyTrainStationExample.createCriteria().andDateEqualTo(date).andTrainCodeEqualTo(trainCode);
        List<DailyTrainStation> list = dailyTrainStationMapper.selectByExample(dailyTrainStationExample);
        return BeanUtil.copyToList(list, DailyTrainStationQueryResponse.class);
    }
}
