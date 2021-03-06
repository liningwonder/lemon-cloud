package io.lemon.cloud.eureka.iam.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
