package com.ashar.profileManager;

import com.ashar.profileManager.constants.BankingDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class FirstBootApplication implements CommandLineRunner {

	@Value("${banking.application.details.name}")
	private String bankName;

	@Value("${banking.application.details.ifsc}")
	private String ifsc;
	@Autowired
	private BankingDetails bankingDetails;
	public static void main(String[] args) {
		SpringApplication.run(FirstBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("BankName , ifsc  {}{}",bankName,ifsc);
		log.info("Banking details {} ",bankingDetails);
	}
}
