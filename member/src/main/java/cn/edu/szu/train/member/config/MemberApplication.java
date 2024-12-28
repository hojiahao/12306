package cn.edu.szu.train.member.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("cn.edu.szu")
public class MemberApplication {
	private static final Logger LOG = LoggerFactory.getLogger(MemberApplication.class);
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MemberApplication.class);
		Environment environment = application.run(args).getEnvironment();
		LOG.info("Start Successfully!");
		LOG.info("address: \thttp://127.0.0.1:{}", environment.getProperty("server.port"));
	}

}
