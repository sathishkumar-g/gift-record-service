package com.sugysri.birthday.giftrecordservice;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sugysri.birthday.giftrecordservice.models.ServiceConstants;

@SpringBootApplication()
//@EnableEurekaClient
//@EnableCaching
public class GiftRecordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiftRecordServiceApplication.class, args);
	}
	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.setReadTimeout(Duration.ofSeconds(30)).build();
	}
	
	@Bean
	public ServiceConstants getServiceConstants() {
		return new ServiceConstants();
	}

}
