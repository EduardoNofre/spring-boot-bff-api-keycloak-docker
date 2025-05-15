package br.com.noticiario.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NoticiarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticiarioApplication.class, args);
	}

}
