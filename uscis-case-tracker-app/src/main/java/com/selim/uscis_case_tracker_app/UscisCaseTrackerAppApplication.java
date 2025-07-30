package com.selim.uscis_case_tracker_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.selim.uscis_case_tracker_app")
public class UscisCaseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UscisCaseTrackerAppApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
