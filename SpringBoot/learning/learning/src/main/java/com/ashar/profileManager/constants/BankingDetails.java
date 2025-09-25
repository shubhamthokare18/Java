package com.ashar.profileManager.constants;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "banking.application.details")
public class BankingDetails {

    private String name;
    private String ifsc;
   private String branch;
   private String city;
    private String state;

}
