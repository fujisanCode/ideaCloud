package com.rai.serviceprovider1;

import javax.validation.constraints.Max.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.rai.serviceprovider1.dao")
//enableEurekaClient只适用于eureka作为注册中心
@EnableEurekaClient
//enableDiscoveryClient适用于其他注册中心
@EnableDiscoveryClient
public class ServiceProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider1Application.class, args);
    }

}

