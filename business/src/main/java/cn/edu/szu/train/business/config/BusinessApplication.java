package cn.edu.szu.train.business.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan("cn.edu.szu")
@MapperScan("cn.edu.szu.train.*.mapper")
@EnableFeignClients("cn.edu.szu.train.business.feign")
@EnableCaching
public class BusinessApplication 
{
    private static final Logger LOG = LoggerFactory.getLogger(BusinessApplication.class);
    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(BusinessApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("Start Successfully!");
        LOG.info( "Test IP Address:\thttp://127.0.0.1:{}{}/hello", env.getProperty("server.port"), env.getProperty("server.servlet.context-path"));
        // 配置规则
        initFlowRules();
        LOG.info("已定义限流规则。");
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("doConfirm");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
