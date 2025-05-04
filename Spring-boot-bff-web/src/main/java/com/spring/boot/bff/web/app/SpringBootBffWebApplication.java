package com.spring.boot.bff.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootBffWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBffWebApplication.class, args);
	}

}
