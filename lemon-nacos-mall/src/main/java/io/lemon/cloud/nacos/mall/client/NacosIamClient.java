package io.lemon.cloud.nacos.mall.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "nacos-iam")
public interface NacosIamClient {

    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);
}
