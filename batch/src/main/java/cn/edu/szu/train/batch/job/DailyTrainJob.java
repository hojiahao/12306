package cn.edu.szu.train.batch.job;

import cn.edu.szu.train.batch.feign.BusinessFeign;
import cn.edu.szu.train.common.response.CommonResp;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Date;

//@DisallowConcurrentExecution
public class DailyTrainJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(DailyTrainJob.class);

    @Resource
    BusinessFeign businessFeign;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 增加日志流水号
        MDC.put("LOG_ID", System.currentTimeMillis() + RandomUtil.randomString(3));
        LOG.info("开始生成15天后的车次数据...");
        Date date = new Date();
        DateTime dateTime = DateUtil.offsetDay(date, 14);
        Date offsetDate = dateTime.toJdkDate();
        CommonResp<Object> commonResp = businessFeign.generateDailyTrain(offsetDate);
        LOG.info("15天后的车次数据生成完成，结果：:{}", commonResp);
    }
}