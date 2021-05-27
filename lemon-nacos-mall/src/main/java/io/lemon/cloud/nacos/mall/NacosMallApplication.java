package io.lemon.cloud.nacos.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosMallApplication {

    public static void main(String[] args) {

        SpringApplication.run(NacosMallApplication.class,args);
    }

}
