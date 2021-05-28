package io.lemon.cloud.nacos.config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {


    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @GetMapping("/config")
    public Boolean config() {
        return useLocalCache;
    }

}
