package cn.edu.szu.train.member.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("cn.edu.szu")
@MapperScan("cn.edu.szu.train.*.mapper")
public class MemberApplication {
	private static final Logger LOG = LoggerFactory.getLogger(MemberApplication.class);
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MemberApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("Start Successfully!");
		LOG.info("Test IP Address: \thttp://127.0.0.1:{}{}/hello", env.getProperty("server.port"), env.getProperty("server.servlet.context-path"));
	}

}
