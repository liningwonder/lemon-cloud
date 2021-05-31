package io.lemon.cloud.eureka.iam.client;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Request.Options options() {
        return new Request.Options();
    }

   /*
    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptor() {
        return new BasicAuthenticationInterceptor("lemon-cloud", "lemon-tree");
    }

    或者自定义实现 RequestInterceptor

    */

}
