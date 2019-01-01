package com.rai.feignconsumer1.feignInterface;

import com.rai.feignconsumer1.domain.User;
import com.rai.feignconsumer1.feignInterface.hystrixImpl.HelloFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 对于eureka中同一个service中的接口只能写在同一个接口类中，否则会因为服务不同类中的同名服务报错
 */
@FeignClient(name = "service-provider1",fallback = HelloFallBack.class)
@Component
public interface UserControllerInterface {

    @GetMapping(value = "/findUser/{uId}")
    public User findUser(@PathVariable("uId") int uId);

    @GetMapping(value = "/helloDocker")
    public String helloDocker();
}
