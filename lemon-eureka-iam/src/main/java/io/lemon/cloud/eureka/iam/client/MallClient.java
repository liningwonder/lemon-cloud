package io.lemon.cloud.eureka.iam.client;

import io.lemon.cloud.eureka.iam.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-mall", configuration = FeignConfig.class)
public interface MallClient {

    @GetMapping("/test")
    String getTest();

}
