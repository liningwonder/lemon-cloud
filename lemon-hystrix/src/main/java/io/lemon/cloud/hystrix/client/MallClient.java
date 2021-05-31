package io.lemon.cloud.hystrix.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-mall", fallback = MallClientCallFallback.class)
public interface MallClient {

    @GetMapping("/test")
    String getTest();

}
