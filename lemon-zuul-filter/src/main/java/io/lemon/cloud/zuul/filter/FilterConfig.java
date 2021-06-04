package io.lemon.cloud.zuul.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public IpFilter ipFilter() {
        return new IpFilter();
    }

}
