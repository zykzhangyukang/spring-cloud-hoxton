### Spring Cloud (H版) 项目搭建模板

> 搭建微服务项目，用于个人的环境搭建提供代码示例，粘贴即可用。

### 1. 项目结构

- cloud-api-commons: 公共模块，封装一些通用的类和工具 
- cloud-consumer-order80: 服务消费者（模拟订单模块）端口:80
- cloud-provider-payment8001: 服务提供者 （模拟支付模块）端口:8001
- cloud-eureka-server7001: 注册中心（eureka）端口: 7001

### 2. 搭建教程

#### 1. 使用Eureka作为注册中心

##### 1. 服务端

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

##### 2. 客户端

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

