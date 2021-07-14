package com.practice.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfigurations {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){

        return builder.routes().
                route(p -> p.path("/get")
                .filters(f -> f
                        .addRequestHeader("Mani", "Bharathi")
                        .addRequestParameter("auth", "auth"))
                        .uri("http://httpbin.org:80"))
                .build();
    }

}
