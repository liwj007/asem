package com.liwj.asem;

import org.apache.ibatis.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.liwj.asem.dao")
@EnableScheduling
public class AsemApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		LogFactory.useLog4JLogging();
		SpringApplication.run(AsemApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AsemApplication.class);
	}
}
