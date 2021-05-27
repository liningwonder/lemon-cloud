package io.lemon.cloud.nacos.config;

import io.lemon.cloud.nacos.config.context.SpringConfigContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LemonNacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(LemonNacosConfigApplication.class, args);
        SpringConfigContextUtil.setApplicationContext(applicationContext);
    }

}
