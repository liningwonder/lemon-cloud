package io.lemon.cloud.eureka.mall.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    //可以使用RibbonConfiguration 配置 Ribbon
    //Ribbon 还可以脱离eureka使用 需要配置eureka-iam的listOfServers
    @LoadBalanced
    @Primary
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @Bean("originRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
