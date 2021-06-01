package io.lemon.cloud.eureka.iam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    //和com.netflix.discovery.EurekaClient的区别
    //org.springframework.cloud.client.discovery.DiscoveryClient
    //子类
    //EurekaDiscoveryClient
    //ConsulDiscoveryClient
    //NacosDiscoveryClient
    //SimpleDiscoveryClient
    //CompositeDiscoveryClient
    @Autowired
    private DiscoveryClient discoveryClient;

    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("STORES");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

    @GetMapping("/iam/hello")
    public String hello() {
        return "lemon cloud";
    }


}
