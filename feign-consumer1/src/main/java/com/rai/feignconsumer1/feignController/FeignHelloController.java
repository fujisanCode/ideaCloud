package com.rai.feignconsumer1.feignController;

import com.rai.feignconsumer1.feignInterface.UserControllerInterface;
import java.text.MessageFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当配置中心更新的时候，自动刷新对应字段
 */
@RestController
@Slf4j
@RefreshScope
public class FeignHelloController {

    /**
     * 通过声明式的接口调用方式调用微服务 同类型的bean只能配置为同名的bean，否则需要按照名称注入对象
     */
    @Autowired
    private UserControllerInterface userControllerInterface;

    /**
     * environment可以读取properties文件
     */
    @Autowired
    private Environment env;

    /**
     * 直接读取文件中的变量
     */
    @Value("${rai.prop.test}")
    private String test;

    /**
     * 此变量包含首先读取配置中心的变量，然后读取本地的变量
     */
    @Value("${rai.local.test}")
    private String localTest;

    /**
     * 直接读取配置中心文件中的变量
     */
    @Value("${rai.test}")
    private String configTest;

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

    @GetMapping("/getConfig")
    public String getConfig() {
        String fieldTest = test;
        String propTest = localTest;
        String fieldConfigTest = configTest;
        String rt = MessageFormat.format(
            "fieldTest -> {0}, propTest -> {1}, fieldConfigTest -> {2}.",
            fieldTest, propTest, fieldConfigTest);
        log.info(rt);
        return rt;
    }


}
