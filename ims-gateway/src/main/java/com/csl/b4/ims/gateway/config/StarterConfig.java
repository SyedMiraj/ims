package com.csl.b4.ims.gateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class StarterConfig {

    @LoadBalanced
    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}
