package com.rai.feignconsumer1.feignInterface;

import com.rai.feignconsumer1.feignInterface.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "service-provider1")
public interface UserControllerInterface {

    @RequestMapping(value = "/findUser/{uId}",method = RequestMethod.GET)
    public User findUser(@PathVariable("uId") int uId);
}
