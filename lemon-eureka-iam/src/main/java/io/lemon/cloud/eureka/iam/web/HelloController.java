package io.lemon.cloud.eureka.iam.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/iam/hello")
    public String hello() {
        return "lemon cloud";
    }


}
