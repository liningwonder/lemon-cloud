package io.lemon.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LemonGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LemonGatewayApplication.class, args);
    }


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        //return builder.routes().build();
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://127.0.0.1:80"))
                .build();
    }

}
