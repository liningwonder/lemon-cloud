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

[官方文档]: https://learn.hashicorp.com/consul

Consul is a full-featured service mesh solution that solves the networking and security challenges of operating microservices and cloud infrastructure.



Consul can run in two modes server or client. Server agents maintain the consistent state for Consul. Clients are a light-weight process that run on every node where services are running.

![Consul datacenter](https://learn.hashicorp.com/img/consul/consul-dc.png)

### Install Consul

------

RPM

```
sudo yum install -y yum-utils
sudo yum-config-manager --add-repo https://rpm.releases.hashicorp.com/RHEL/hashicorp.repo
sudo yum -y install consul

consul --version
```

Binary 

[二进制包下载]: https://www.consul.io/downloads
[consul_1.9.5_linux_amd64.zip]: https://releases.hashicorp.com/consul/1.9.5/consul_1.9.5_linux_amd64.zip



```
unzip consul_1.9.5_linux_amd64.zip
添加系统变量
```



### Run Consul Agent

------



In production you would run each Consul agent in either in server or client mode。生产环境使用3或5台的Consul集群

```
#开发模式启动,生产不建议
consul agent -dev

```



### Stop Consul Agent

------

```
consul leave
```



###  Lists the agents in the datacenter

------

```
consul members

或者

curl localhost:8500/v1/catalog/nodes
```



### UI

------

```
http://localhost:8500/ui
```

