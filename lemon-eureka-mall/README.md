---
title: Lemon Cloud Ribbon
categories: Lemon Cloud
date: 2021-05-25 00:00:00
tags:
- Lemon Cloud
- Ribbon
---

<!-- toc -->
----------



## Ribbon

Ribbon is a client-side load balancer

Feign already uses Ribbon, so, if you use @FeignClient, this section also applies.

spring-cloud-starter-netflix-ribbon



```

@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class)
public class RibbonClientDefaultConfigurationTestsConfig {

    public static class BazServiceList extends ConfigurationBasedServerList {

        public BazServiceList(IClientConfig config) {
            super.initWithNiwsConfig(config);
        }

    }

}

@Configuration(proxyBeanMethods = false)
class DefaultRibbonConfig {

    @Bean
    public IRule ribbonRule() {
        return new BestAvailableRule();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

    @Bean
    public ServerList<Server> ribbonServerList(IClientConfig config) {
        return new RibbonClientDefaultConfigurationTestsConfig.BazServiceList(config);
    }

    @Bean
    public ServerListSubsetFilter serverListFilter() {
        ServerListSubsetFilter filter = new ServerListSubsetFilter();
        return filter;
    }

}




```