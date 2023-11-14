package com.csl.b4.ims.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ImsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsGatewayApplication.class, args);
	}

}
