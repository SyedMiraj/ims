package com.csl.b4.ims.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ImsServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsServiceRegistryApplication.class, args);
	}

}
