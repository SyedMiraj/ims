package com.csl.b4.ims.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ImsCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsCloudConfigApplication.class, args);
	}

}
