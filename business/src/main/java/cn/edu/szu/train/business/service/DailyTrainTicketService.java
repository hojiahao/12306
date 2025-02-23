package cn.edu.szu.train.business.service;

import cn.edu.szu.train.business.domain.DailyTrain;
import cn.edu.szu.train.business.domain.TrainStation;
import cn.edu.szu.train.business.enums.SeatTypeEnum;
import cn.edu.szu.train.business.enums.TrainTypeEnum;
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
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

@Service
public class DailyTrainTicketService {
    private static final Logger LOG = LoggerFactory.getLogger(DailyTrainTicketService.class);

    @Resource
    private DailyTrainTicketMapper dailyTrainTicketMapper;

    @Resource
    private TrainStationService trainStationService;

    @Resource
    private DailyTrainSeatService dailyTrainSeatService;

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

    @Cacheable(value = "DailyTrainTicketService.queryList3")
    public PageResp<DailyTrainTicketQueryResponse> queryList3(DailyTrainTicketQueryReq req) {
        LOG.info("测试缓存击穿");
        return null;
    }


    public PageResp<DailyTrainTicketQueryResponse> queryList(DailyTrainTicketQueryReq req) {
        // 常见的缓存过期策略
        // TTL 超时时间
        // LRU 最近最少使用
        // LFU 最近最不经常使用
        // FIFO 先进先出
        // Random 随机淘汰策略
        // 去缓存里取数据，因数据库本身就没数据而造成缓存穿透
        // if (有数据) { null []
        //     return
        // } else {
        //     去数据库取数据
        // }
        DailyTrainTicketExample dailyTrainTicketExample = new DailyTrainTicketExample();
        dailyTrainTicketExample.setOrderByClause("`date` desc, departure_time asc, train_code asc, `departure_index` asc, `arrival_index` asc");
        DailyTrainTicketExample.Criteria criteria = dailyTrainTicketExample.createCriteria();
        if (ObjectUtil.isNotNull(req.getDate())) {
            criteria.andDateEqualTo(req.getDate());
        }
        if (ObjectUtil.isNotEmpty(req.getTrainCode())) {
            criteria.andTrainCodeEqualTo(req.getTrainCode());
        }
        if (ObjectUtil.isNotEmpty(req.getDeparture())) {
            criteria.andDepartureEqualTo(req.getDeparture());
        }
        if (ObjectUtil.isNotEmpty(req.getDestination())) {
            criteria.andDestinationEqualTo(req.getDestination());
        }

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

    @Transactional
    public void generateDailyTrainTicket(DailyTrain dailyTrain, Date date, String trainCode) {
        LOG.info("生成日期【{}】车次【{}】的余票信息开始", DateUtil.formatDate(date), trainCode);
        // 删除某日某车次的余票信息
        DailyTrainTicketExample dailyTrainTicketExample = new DailyTrainTicketExample();
        dailyTrainTicketExample.createCriteria().andDateEqualTo(date).andTrainCodeEqualTo(trainCode);
        dailyTrainTicketMapper.deleteByExample(dailyTrainTicketExample);

        // 查出某车次的所有的车站信息
        List<TrainStation> trainStations = trainStationService.selectByTrainCode(trainCode);
        if (CollUtil.isEmpty(trainStations)) {
            LOG.info("该车次没有车站基础数据，生成该车次的余票信息结束");
            return;
        }

        DateTime now = DateTime.now();
        for (int i = 0; i < trainStations.size(); i++) {
            // 得到出发站
            TrainStation departure = trainStations.get(i);
            BigDecimal sumKM = BigDecimal.ZERO;
            for (int j = (i + 1); j < trainStations.size(); j++) {
                TrainStation destination = trainStations.get(j);
                sumKM = sumKM.add(destination.getKilometers());
                DailyTrainTicket dailyTrainTicket = new DailyTrainTicket();
                dailyTrainTicket.setId(SnowUtil.getSnowflakeNextId());
                dailyTrainTicket.setDate(date);
                dailyTrainTicket.setTrainCode(trainCode);
                dailyTrainTicket.setDeparture(departure.getName());
                dailyTrainTicket.setDeparturePinyin(departure.getNamePinyin());
                dailyTrainTicket.setDepartureTime(departure.getExitTime());
                dailyTrainTicket.setDepartureIndex(departure.getIndex());
                dailyTrainTicket.setDestination(destination.getName());
                dailyTrainTicket.setDestinationPinyin(destination.getNamePinyin());
                dailyTrainTicket.setArrivalTime(destination.getEntryTime());
                dailyTrainTicket.setArrivalIndex(destination.getIndex());
                int firstClass = dailyTrainSeatService.countSeat(date, trainCode, SeatTypeEnum.FIRST_CLASS.getCode());
                int secondClass = dailyTrainSeatService.countSeat(date, trainCode, SeatTypeEnum.SECOND_CLASS.getCode());
                int softSleeper = dailyTrainSeatService.countSeat(date, trainCode, SeatTypeEnum.SOFT_SLEEPER.getCode());
                int hardSleeper = dailyTrainSeatService.countSeat(date, trainCode, SeatTypeEnum.HARD_SLEEPER.getCode());
                // 票价 = 里程之和 * 座位单价 * 车次类型系数
                String trainType = dailyTrain.getType();
                // 计算票价系数：TrainTypeEnum.priceRate
                BigDecimal priceRate = EnumUtil.getFieldBy(TrainTypeEnum::getPriceRate, TrainTypeEnum::getCode, trainType);
                BigDecimal firstClassPrice = sumKM.multiply(SeatTypeEnum.FIRST_CLASS.getPrice()).multiply(priceRate).setScale(2, RoundingMode.HALF_UP);
                BigDecimal secondClassPrice = sumKM.multiply(SeatTypeEnum.SECOND_CLASS.getPrice()).multiply(priceRate).setScale(2, RoundingMode.HALF_UP);
                BigDecimal softSleeperPrice = sumKM.multiply(SeatTypeEnum.SOFT_SLEEPER.getPrice()).multiply(priceRate).setScale(2, RoundingMode.HALF_UP);
                BigDecimal hardSleeperPrice = sumKM.multiply(SeatTypeEnum.HARD_SLEEPER.getPrice()).multiply(priceRate).setScale(2, RoundingMode.HALF_UP);
                dailyTrainTicket.setFirstClass(firstClass);
                dailyTrainTicket.setFirstClassPrice(firstClassPrice);
                dailyTrainTicket.setSecondClass(secondClass);
                dailyTrainTicket.setSecondClassPrice(secondClassPrice);
                dailyTrainTicket.setSoftSleeper(softSleeper);
                dailyTrainTicket.setSoftSleeperPrice(softSleeperPrice);
                dailyTrainTicket.setHardSleeper(hardSleeper);
                dailyTrainTicket.setHardSleeperPrice(hardSleeperPrice);
                dailyTrainTicket.setCreateTime(now);
                dailyTrainTicket.setUpdateTime(now);
                dailyTrainTicketMapper.insert(dailyTrainTicket);
            }
        }
        LOG.info("生成日期【{}】车次【{}】的余票信息结束", DateUtil.formatDate(date), trainCode);
    }

    public DailyTrainTicket selectByUnique(Date date, String trainCode, String departure, String destination) {
        DailyTrainTicketExample dailyTrainTicketExample = new DailyTrainTicketExample();
        dailyTrainTicketExample.createCriteria()
                .andDateEqualTo(date)
                .andTrainCodeEqualTo(trainCode)
                .andDepartureEqualTo(departure)
                .andDestinationEqualTo(destination);
        List<DailyTrainTicket> list = dailyTrainTicketMapper.selectByExample(dailyTrainTicketExample);
        if (CollUtil.isNotEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
