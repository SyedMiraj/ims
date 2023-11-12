package com.csl.b4.ims.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
//        ParameterBuilder parameterBuilder = new ParameterBuilder();
//        parameterBuilder.name("Authorization")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .description("JWT token")
//                .build();
//        List<Parameter> parameters = new ArrayList<>();
//        parameters.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.csl.b4.ims.user"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
//                .globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Inventory Management System API")
                .description("REST API For Inventory Management System").termsOfServiceUrl("")
                .contact(new Contact("Shahriar Miraj", "", "smiraj2507@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1")
                .build();
    }
}
