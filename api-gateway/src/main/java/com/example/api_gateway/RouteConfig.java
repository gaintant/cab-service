package com.example.api_gateway;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for user
//                .route("user", r -> r.path("/user/**")
//                        .uri("lb://USER"))
//                // Route for sample client
//                .route("SAMPLE-CLIENT", r -> r.path("/sample/**")
//                        .uri("lb://SAMPLE-CLIENT"))
                .route("stakeholder", r -> r.path("/hello/**")
                        .uri("lb://STAKEHOLDER"))

                .build();
    }
}

