package com.lboeri.boeriapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,MongoAutoConfiguration.class})
@MapperScan("com.lboeri.boeriapi.dao.**")
public class BoeriApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoeriApiApplication.class, args);
	}
}
