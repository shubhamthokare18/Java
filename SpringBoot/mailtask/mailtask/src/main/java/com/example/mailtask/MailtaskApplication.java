package com.example.mailtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MailtaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailtaskApplication.class, args);
	}

}
