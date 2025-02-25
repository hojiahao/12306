package cn.edu.szu.train.business.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("cn.edu.szu")
@MapperScan("cn.edu.szu.train.*.mapper")
@EnableFeignClients("cn.edu.szu.train.business.feign")
public class BusinessApplication 
{
    private static final Logger LOG = LoggerFactory.getLogger(BusinessApplication.class);
    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(BusinessApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("Start Successfully!");
        LOG.info( "Test IP Address:\thttp://127.0.0.1:{}{}/hello", env.getProperty("server.port"), env.getProperty("server.servlet.context-path"));
    }
}
