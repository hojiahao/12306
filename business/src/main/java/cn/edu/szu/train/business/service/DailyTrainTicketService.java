package cn.edu.szu.train.business.service;

import cn.edu.szu.train.business.domain.DailyTrain;
import cn.edu.szu.train.business.domain.TrainStation;
import cn.edu.szu.train.business.enums.SeatTypeEnum;
import cn.edu.szu.train.business.enums.TrainTypeEnum;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.domain.DailyTrainTicket;
import cn.edu.szu.train.business.domain.DailyTrainTicketExample;
import cn.edu.szu.train.business.mapper.DailyTrainTicketMapper;
import cn.edu.szu.train.business.request.DailyTrainTicketQueryRequest;
import cn.edu.szu.train.business.request.DailyTrainTicketSaveRequest;
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
import org.springframework.cache.annotation.CachePut;
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

    public void save(DailyTrainTicketSaveRequest req) {
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

    @CachePut(value = "DailyTrainTicketService.queryList3")
    public PageResponse<DailyTrainTicketQueryResponse> queryList3(DailyTrainTicketQueryRequest req) {
        LOG.info("测试缓存击穿");
        return null;
    }

    @CachePut(value = "DailyTrainTicketService.queryList")
    public PageResponse<DailyTrainTicketQueryResponse> queryList2(DailyTrainTicketQueryRequest req) {
        return queryList(req);
    }

    /**
     * 缓存穿透是指查询不存在于缓存和数据库中的数据。恶意用户可能会利用这一点，不断发起不存在的数据请求，导致所有请求都直接访问数据库，从而给数据库带来巨大压力。
     * 为了防止缓存穿透，可以采取以下措施：
     * 1.对请求进行校验，比如用户鉴权和基础参数校验，拦截不合法的请求。
     * 2.对于查询不到的数据，即使在数据库中也不存在，也可以在缓存中设置一个空值，缓存有效时间设置短一些，如30秒，以防止恶意攻击。
     * 缓存击穿是指缓存中没有但数据库中有的数据。通常发生在一个热点 key 失效的瞬间，此时可能会有大量的并发请求查询这个 key，因为缓存中没有数据，所有请求都会落到数据库上，造成数据库瞬间压力过大。
     * 解决缓存击穿的方法包括：
     * 1.将热点数据设置为永不过期。
     * 2.接口限流与熔断，降级。重要的接口一定要做好限流策略，防止用户恶意刷接口，同时要降级准备，当接口中的某些服务不可用时候，进行熔断，失败快速返回机制。
     * 3.布隆过滤器。bloomfilter就类似于一个hash set，用于快速判某个元素是否存在于集合中，其典型的应用场景就是快速判断一个key是否存在于某容器，不存在就直接返回。
     * 4.使用互斥锁来确保同时只有一个请求去数据库查询数据并更新缓存。
     * 缓存雪崩是指在缓存中大量数据同时过期，或者 Redis 宕机，导致大量请求无法在缓存中处理，全部落到数据库上。解决缓存雪崩的方法包括：
     * 1.将缓存数据的过期时间设置为随机，避免大量数据同时过期。
     * 2.如果缓存数据库是分布式部署，将热点数据均匀分布在不同的缓存数据库中。
     * 3.设置热点数据永不过期。
     */
    @Cacheable(value = "DailyTrainTicketService.queryList")
    public PageResponse<DailyTrainTicketQueryResponse> queryList(DailyTrainTicketQueryRequest req) {
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

        PageResponse<DailyTrainTicketQueryResponse> pageResponse = new PageResponse<>();
        pageResponse.setTotal(pageInfo.getTotal());
        pageResponse.setRows(list);
        return pageResponse;
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
