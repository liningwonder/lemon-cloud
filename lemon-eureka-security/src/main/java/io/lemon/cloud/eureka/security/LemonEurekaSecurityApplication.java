package io.lemon.cloud.eureka.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LemonEurekaSecurityApplication {

    //eureka.client.serviceUrl.defaultZone=http://lemon-cloud:lemon-tree@localhost:8761/eureka/
    public static void main(String[] args) {
        SpringApplication.run(LemonEurekaSecurityApplication.class, args);
    }

}
