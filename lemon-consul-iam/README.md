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

When a client registers with Consul, it provides meta-data about itself such as host and port, id, name and tags. An HTTP Check is created by default that Consul hits the /actuator/health endpoint every 10 seconds. If the health check fails, the service instance is marked as critical.



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

