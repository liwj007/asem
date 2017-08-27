package com.liwj.asem;

import org.apache.ibatis.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liwj.asem.dao")
public class AsemApplication {

	public static void main(String[] args) {
		LogFactory.useLog4JLogging();
		SpringApplication.run(AsemApplication.class, args);
	}
}
