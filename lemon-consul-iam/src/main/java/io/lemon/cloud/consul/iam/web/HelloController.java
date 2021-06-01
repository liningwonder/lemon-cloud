package io.lemon.cloud.consul.iam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    //很多子类实现，最终会加载ConsulDiscoveryClient
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public String hello() {
        return "lemon cloud";
    }

    public String getFirstProduct() {
        return this.restTemplate.getForObject("https://STORES/products/1", String.class);
    }

    @GetMapping("/services")
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("consul-iam");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

    @GetMapping("/discover")
    public Object discover() {
        return loadBalancerClient.choose("service-producer").getUri().toString();
    }

}
