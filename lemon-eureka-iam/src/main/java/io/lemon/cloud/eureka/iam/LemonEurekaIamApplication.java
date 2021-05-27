package io.lemon.cloud.eureka.iam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LemonEurekaIamApplication {

    public static void main(String[] args) {
        SpringApplication.run(LemonEurekaIamApplication.class, args);
    }

}
