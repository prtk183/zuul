package com.sbank;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.sbank.controller.BankController;
import com.sbank.model.Bank;

//mysql
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Configuration
public class SBankApplication {
  
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
     // Do any additional configuration here
     return builder.build();
  }
	public static void main(String[] args) {
		SpringApplication.run(SBankApplication.class, args);
	}
	
	public SBankApplication(){};
	

}
