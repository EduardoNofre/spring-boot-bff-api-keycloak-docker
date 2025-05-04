package com.spring.boot.bff.mobile.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class SpringBootBffMobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBffMobileApplication.class, args);
	}

}
