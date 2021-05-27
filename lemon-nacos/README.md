---
title: Lemon Cloud Nacos
categories: Lemon Cloud
date: 2021-05-25 00:00:00
tags:
- Lemon Cloud
- Nacos
---

<!-- toc -->
----------



## Nacos

Nacos 致力于帮助您发现、配置和管理微服务。Nacos 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。

Nacos 的关键特性包括:

**服务发现和服务健康监测**

**动态配置服务**

**动态 DNS 服务**

**服务及其元数据管理**



### Nacos优势

![nacos_map](https://nacos.io/img/nacosMap.jpg)

### Nacos生态

![nacos_landscape.png](https://cdn.nlark.com/lark/0/2018/png/11189/1533045871534-e64b8031-008c-4dfc-b6e8-12a597a003fb.png)



### 版本控制

- 1.5.x for Spring Boot 1.5.x
- 2.0.x for Spring Boot 2.0.x
- 2.1.x for Spring Boot 2.1.x
- 2.2.x for Spring Boot 2.2.x
- 2020.x for Spring Boot 2.4.x



### 负载均衡

Nacos Discovery integrate with the Netflix Ribbon, RestTemplate or OpenFeign can be used for service-to-service calls.



### Nacos安装

[二进制包下载]: https://github.com/alibaba/nacos/releases/tag/2.0.1

```
tar -zxvf nacos-server-2.0.1.tar.gz
cd nacos/bin
sh startup.sh -m standalone
```

访问：http://192.168.67.25:8848/nacos/index.html

**nacos/nacos** 

生产环境部署

https://nacos.io/zh-cn/docs/deployment.html