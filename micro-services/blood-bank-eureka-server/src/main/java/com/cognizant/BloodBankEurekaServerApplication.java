package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class BloodBankEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankEurekaServerApplication.class, args);
	}

}
