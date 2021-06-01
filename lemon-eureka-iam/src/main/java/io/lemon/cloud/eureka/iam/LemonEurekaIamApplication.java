package io.lemon.cloud.eureka.iam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient 通用注解
//@EnableEurekaClient 专用注解
public class LemonEurekaIamApplication {

    public static void main(String[] args) {
        SpringApplication.run(LemonEurekaIamApplication.class, args);
    }

}
