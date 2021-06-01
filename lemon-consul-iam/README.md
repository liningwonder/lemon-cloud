---

title: Lemon Cloud Consul
categories: Lemon Cloud Consul
date: 2021-05-25 00:00:00
tags:
- Lemon Cloud
- Consul
---

<!-- toc -->
----------



## Consul

Service Discovery: instances can be registered with the Consul agent and clients can discover the instances using Spring-managed beans

Supports Ribbon, the client side load-balancer via Spring Cloud Netflix

Supports Spring Cloud LoadBalancer - a client side load-balancer provided by the Spring Cloud project

Supports Zuul, a dynamic router and filter via Spring Cloud Netflix

Distributed Configuration: using the Consul Key/Value store

Control Bus: Distributed control events using Consul Events
When a client registers with Consul, it provides meta-data about itself such as host and port, id, name and tags. An HTTP Check is created by default that Consul hits the /actuator/health endpoint every 10 seconds. If the health check fails, the service instance is marked as critical.


Consul provides a Key/Value Store for storing configuration and other metadata. 
Spring Cloud Consul Config is an alternative to the Config Server and Client. Configuration is loaded into the Spring Environment during the special "bootstrap" phase.



```
https://docs.spring.io/spring-cloud-consul/docs/2.2.7.RELEASE/reference/html/
```


```
spring:
  cloud:
    consul:
      discovery:
        healthCheckPath: ${management.server.servlet.context-path}/actuator/health
        healthCheckInterval: 15s
```



```
spring:
  cloud:
    consul:
      discovery:
        instanceId: ${spring.application.name}:${vcap.application.instance_id:${spring.application.instance_id:${random.value}}}
```

