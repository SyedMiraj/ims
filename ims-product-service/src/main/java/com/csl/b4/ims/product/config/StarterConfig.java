package com.csl.b4.ims.product.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.csl.b4.ims.product.feign")
public class StarterConfig {
}
