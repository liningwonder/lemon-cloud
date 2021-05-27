package io.lemon.cloud.nacos.config.web;

import io.lemon.cloud.nacos.config.context.SpringConfigContextUtil;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @GetMapping("/config")
    public String config() {
        ConfigurableApplicationContext applicationContext = SpringConfigContextUtil.getApplicationContext();
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        String projectName = applicationContext.getEnvironment().getProperty("project.name");
        System.err.println("user name :" +userName+"; age: "+userAge);
        return projectName;
    }

}
