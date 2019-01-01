package com.rai.feignconsumer1.feignInterface.hystrixImpl;

import com.rai.feignconsumer1.domain.User;
import com.rai.feignconsumer1.feignInterface.UserControllerInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 此类继承远程调用的接口，类中的回调方法在远程接口调用错误的情况下调用
 */
@Component
@Slf4j
public class HelloFallBack implements UserControllerInterface {

    @Override
    public User findUser(int uId) {
        log.info("feign: remote Hello error.");
        return null;
    }

    @Override
    public String helloDocker() {
        return "feign: remote Hello error.";
    }
}
