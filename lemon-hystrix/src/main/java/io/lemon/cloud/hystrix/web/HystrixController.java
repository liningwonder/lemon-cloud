package io.lemon.cloud.hystrix.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hystrix")
    @HystrixCommand(fallbackMethod = "defaultCall")
    public String hystrix() {
        String result =  restTemplate.getForObject("http://127.0.0.1:9005/iam/accessToken", String.class);
        return result;
    }

    public String defaultCall() {
        return "hystrix";
    }

}
