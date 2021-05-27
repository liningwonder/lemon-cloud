package io.lemon.cloud.eureka.mall.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/mall")
@RestController
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("originRestTemplate")
    private RestTemplate originRestTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/login")
    public String login() {
        return originRestTemplate.getForObject("http://127.0.0.1:9005/iam/accessToken", String.class);
    }

    @GetMapping("/haha")
    public String accessToken() {
        return restTemplate.getForObject("http://eureka-iam/iam/accessToken", String.class);
    }


    @GetMapping("/another")
    public String another() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://eureka-iam/iam/accessToken", String.class);
        if (200 == responseEntity.getStatusCodeValue()) {
            return responseEntity.getBody();
        }
        return null;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }


    @GetMapping("service")
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("eureka-iam");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

    @GetMapping("balance")
    public String balance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-iam");
        if ( null != serviceInstance ) {
            return serviceInstance.getUri().toString();
        }
        return null;
    }

}
