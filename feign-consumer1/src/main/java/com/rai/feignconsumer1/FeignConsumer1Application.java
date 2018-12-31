package com.rai.feignconsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 注册服务  暴露服务  feign调用服务
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumer1Application.class, args);
    }

}

