package io.lemon.cloud.eureka.iam.web;

import io.lemon.cloud.common.token.JwtUtils;
import io.lemon.cloud.eureka.iam.client.MallClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private MallClient mallClient;

    @GetMapping("/iam/accessToken")
    public String accessToken() {
        return JwtUtils.generateToken("lining");
    }

    @GetMapping("/iam/test")
    public String test() {
        return mallClient.getTest();
    }

}
