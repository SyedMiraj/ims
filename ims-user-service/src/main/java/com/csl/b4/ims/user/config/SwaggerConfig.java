package com.csl.b4.ims.user.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("IMS-USER")
                .packagesToScan("com.csl.b4.ims.user")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("IMS-USER API")
                        .description("REST API For Inventory Management System (User-Module)")
                        .contact(new Contact().name("Shahriar Miraj").email("smiraj2507@gmail.com"))
                        .version("1.0")
                        .license(new License().name("Apache 2.0")));
    }
}
