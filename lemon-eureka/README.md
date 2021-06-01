---
title: Lemon Cloud
categories: Lemon Cloud
date: 2021-05-25 00:00:00
tags:
- Lemon Cloud
- Eureka
---

<!-- toc -->
----------



## Eureka

Eureka is the Netflix Service Discovery Server and Client. The server can be configured and deployed to be highly available, with each server replicating state about the registered services to the others.



 Eureka server is also a Eureka client.

 

Eureka的服务注册信息在磁盘中。







基本概念



区域-Region

是数据中心的物理位置，例如华东，华南等。



可用区-Zone

物理上再同一个区域，但是不同的可用区，集群的网络，电力等都是相互隔离的。



多个Eureka实例之间可以通过相互复制来同步服务注册表的信息。



（1）服务注册

（2）心跳、健康、续租检查

（3）缓存



服务端配置说明：

**Standalone Eureka Server**

```
eureka.client.registerWithEureka fasle  表示不将自己注册到Eureka
eureka.client.fetchRegistry      fasle  表示是否从Eureka获取注册信息
eureka.client.service-url.defaultZone 默认是http://localhost:8761/eureka ，即设置Eureka的访问地址
eureka.instance.metadataMap.zone = zone1 定义Eureka所属的zone的名称
eureka.client.preferSameZoneEureka = true 倾向于访问属于同一个可用区的eureka
eureka.instance.statusPageUrlPath=${server.servletPath}/info
eureka.instance.healthCheckUrlPath=${server.servletPath}/health
eureka.server.enable-self-preservation false 禁用自我保护，网络分区问题
spring.cloud.inetutils.ingored-interfaces.docker0.verth=* 网卡选择
eureka.instance.ip-address=127.0.0.1 指定IP

eureka.client.healthcheck.enable=true 启用eureka健康检查


spring.cloud.loadbalancer.ribbon.enabled=false

eureka.server.eviction-interval-timer-in-ms=5000


```

访问：http://127.0.0.1:8761/



高可用配置：

### High Availability, Zones and Regions



本地添加主机名（127.0.0.1 peer1 peer2）

application.yml

```

server:
  port: 8761

spring:
  application:
    name: lemon-eureka
  profiles: peer1  

eureka:
  instance:
    hostname: peer1
  client:
    service-url:
      defaultZone: http://peer2:8762/eureka/

```

application.yml

```
spring:
  application:
    name: lemon-eureka
spring:
  profiles: peer2
server:
  port: 8762  
eureka:
  instance:
    hostname: peer2
  client:
    service-url:
      defaultZone: http://peer1:8761/eureka/
```

<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-ribbon</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>com.netflix.ribbon</groupId>
                    <artifactId>ribbon-eureka</artifactId>
                </exclusion>
            </exclusions>
</dependency>







客户端配置说明：

```
spring.application.name                    注册到Eureka的名字
eureka.client.serviceUrl.defaultZone       Eureka的访问地址
eureka.client.instance.prefer-ip-address   表示将自己的IP注册到Eureka上，如果不设置，则默认使用主机的hostname
```

// @EnableEurekaClient 新版本的Spring Cloud 可以不使用这个
// @EnableDiscoveryClient 这两者的区别 当注册中心不用eureka时，新版本可以不使用这个



安装

使用Spring Cloud 包含一个嵌入的Eureka服务器并启动它。

```
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.10.RELEASE</version>
        <relativePath/>
    </parent>
    
    <properties>
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <spring-cloud.version>Hoxton.SR11</spring-cloud.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

application.yml (Standalone Eureka Server)

```
server:
  port: 8761

eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

