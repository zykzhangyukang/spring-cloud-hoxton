### Spring Cloud (H版) 项目搭建模板

> 搭建微服务项目，用于个人的环境搭建提供代码示例，粘贴即可用。

## 1. 项目结构

- cloud-api-commons: 公共模块，封装一些通用的类和工具 
- cloud-consumer-order80: 服务消费者（模拟订单模块）端口:80
- cloud-consumer-order80-zk: 服务消费者（模拟订单模块）,zookeeper作为 服务注册中心 端口:80
- cloud-consumer-order80-consul: 服务消费者（模拟订单模块）,consul作为 服务注册中心 端口:80
- cloud-provider-payment8001: 服务提供者 （模拟支付模块）端口:8001
- cloud-provider-payment8002: 服务提供者 （模拟支付模块）端口:8002
- cloud-provider-payment8003-zk: 服务提供者 （模拟支付模块）,zookeeper作为 服务注册中心 端口:8003
- cloud-provider-payment8004-consul: 服务提供者 （模拟支付模块）,consul 服务注册中心 端口:8004
- cloud-eureka-server7001: 服务注册中心（eureka）端口: 7001
- cloud-eureka-server7002: 服务注册中心（eureka）端口: 7002
- cloud-eureka-server7003: 服务注册中心（eureka）端口: 7003

## 2. 搭建教程

### 1. 使用Eureka作为注册中心

#### 1. 服务端

- 引入依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

- application.yml 配置

```yml
eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://${server.port}:${server.port}/eureka/
```

- 启动类添加注解

```java
@SpringBootApplication
@EnableEurekaServer
public class Eureka7001Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001Application.class,args);
    }
}
```

#### 2. 客户端

- 引入依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

- application.yml配置

```yml
eureka:
  instance:
    instance-id: cloud-payment-service-8001 # 修改实例的别名
    prefer-ip-address: true # 显示IP
  client:
    service-url:
      defaultZone: http://localhost:7001/eureka #注册服务到eureka服务器
```

- 启动类添加注解

```java
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.coderman.payment.mapper"})
public class Payment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Application.class,args);
    }
}
```

### 2. 使用Eureka集群

#### 1. 配置host文件
```text
# 配置eureka集群
127.0.0.1 server1.com
127.0.0.1 server2.com
127.0.0.1 server3.com
```
#### 2. 服务端

- 修改application.yml

```yml
server:
  port: 7001
eureka:
  instance:
    hostname: server1.com
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://server2.com:7002/eureka/,http://server3.com:7003/eureka/
```

#### 3. 客户端

- 修改application.yml

```yml
#eureka客户端的配置
eureka:
  instance:
    instance-id: cloud-payment-service-8001 # 修改实例的别名
    prefer-ip-address: true # 显示IP
  client:
    service-url:
      defaultZone: http://server1.com:7001/eureka/,http://server2.com:7002/eureka/,http://server3.com:7003/eureka/ #注册服务到eureka服务器
```

### 3. 使用Ribbon实现负载均衡

> 因为引入的eureka客户端依赖里包含了Ribbon的依赖，因此不需要到入任何的依赖,使用起来也非常简单
>只需要两步即可。

- 修改Rest服务调用的地址,对应Eureka服务列表的服务名称。

```java
private final String REST_URL = "http://CLOUD-PAYMENT-SERVICE";
```

- 开启RestTemplate负载均衡功能

```java
 @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
}
```

### 4. 使用Zookeeper作为注册中心
> 安装zookeeper服务端,启动本地的zookeeper服务器即可。

#### 1. 客户端

- 引入依赖

```xml
 <!--SpringBoot整合Zookeeper客户端-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
    <!--先排除自带的zookeeper3.5.3-->
   <exclusions>
       <exclusion>
           <groupId>org.apache.zookeeper</groupId>
           <artifactId>zookeeper</artifactId>
       </exclusion>
   </exclusions>
</dependency>
<!--添加zookeeper3.4.10版本-->
<dependency>
    <groupId>org.apache.zookeeper</groupId>
    <artifactId>zookeeper</artifactId>
    <version>3.4.10</version>
    <exclusions>
        <exclusion>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
        </exclusion>
        <exclusion>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
        </exclusion>
        <exclusion>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

- 配置application.yml

```yml
spring:
   cloud:
    zookeeper:
      # 默认localhost:2181
      connect-string: localhost:2181
```

- 配置启动类

```java
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.coderman.payment.mapper"})
public class Payment8003Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8003Application.class,args);
    }
}
```


### 5. 使用Consul作为注册中心
> 安装consul服务端,启动本地的consul服务器即可。

#### 1. 客户端

- 引入依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-consul-discovery</artifactId>
</dependency>
```

- 配置application.yml

```yml
 #配置consul客户端
spring:   
  cloud:
    consul:
      host: localhost
      port: 8500
      discovery:
        service-name: ${spring.application.name}
        heartbeat:
          enabled: true
```

- 配置启动类

```java
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.coderman.payment.mapper"})
public class Payment8004ConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004ConsulApplication.class,args);
    }
}

```


