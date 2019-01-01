package com.rai.feignconsumer1.feignController;

import com.rai.feignconsumer1.feignInterface.UserControllerInterface;
import java.text.MessageFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignHelloController {

    /**
     * 通过声明式的接口调用方式调用微服务
     * 同类型的bean只能配置为同名的bean，否则需要按照名称注入对象
     */
    @Autowired
    private UserControllerInterface userControllerInterface;

    /**
     * environment可以读取properties文件
     */
    @Autowired
    private Environment env;

    @GetMapping("/getRemoteHello")
    public String getRemoteHello() {
        //如果调用远程接口失败，会返回回调方法中返回的结果
        String rt = userControllerInterface.helloDocker();
        String feignPort = env.getProperty("server.port");
        log.info("remoteHello -> {},feignServer -> {}.", rt, feignPort);
        return MessageFormat.format(
            "Feign Service: remoteHelloMsg -> {0}, feignHelloMsg -> {1}.", rt,
            feignPort);
    }

}
