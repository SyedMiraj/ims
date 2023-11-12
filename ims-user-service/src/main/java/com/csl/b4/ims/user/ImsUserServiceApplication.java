package com.csl.b4.ims.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImsUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsUserServiceApplication.class, args);
	}

}
