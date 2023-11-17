package com.csl.b4.ims.gateway.config;

import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Objects;

@Configuration
public class SwaggerConfig {
    @Bean
    public CommandLineRunner openApiGroups(
            RouteDefinitionLocator locator,
            SwaggerUiConfigParameters swaggerUiParameters) {
        List<RouteDefinition> block = locator.getRouteDefinitions().collectList().block();
        return args -> Objects.requireNonNull(locator
                        .getRouteDefinitions().collectList().block())
                .stream()
                .map(RouteDefinition::getId)
                .filter(id -> id.matches(".*-SERVICE"))
                .map(id -> id.replace("-SERVICE", ""))
                .forEach(swaggerUiParameters::addGroup);
    }
}
