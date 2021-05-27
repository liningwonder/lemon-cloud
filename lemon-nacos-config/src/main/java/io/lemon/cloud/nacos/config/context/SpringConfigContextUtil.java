package io.lemon.cloud.nacos.config.context;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringConfigContextUtil{

    private static ConfigurableApplicationContext applicationContext;

    public static void setApplicationContext(ConfigurableApplicationContext applicationContext) {
        SpringConfigContextUtil.applicationContext = applicationContext;
    }

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
