package com.example.actionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ActionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActionserviceApplication.class, args);
	}

}
