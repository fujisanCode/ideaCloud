package com.rai.serviceprovider1.controller;

import java.text.MessageFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloDocker {
    @Autowired
    private ApplicationContext context;

    /**
     * 本应用的port，对于调用本应用服务的调用者来说，本应用属于server的范畴
     */
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/helloDocker")
    public String helloDocker() {
        log.info("helloDocker {}", "argument1");
        return MessageFormat.format( "helloDocker: port -> {0}.",serverPort);
    }
}
