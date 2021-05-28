package io.lemon.cloud.nacos.mall.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean("originRestTemplate")
    public RestTemplate originRestTemplate(){
        return new RestTemplate();
    }

    @LoadBalanced
    @Bean("loadBalancedRestTemplate")
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }

}
