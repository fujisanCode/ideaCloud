package com.rai.feignconsumer1.feignController;

import com.rai.feignconsumer1.feignInterface.UserControllerInterface;
import com.rai.feignconsumer1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignUserController {

    @Autowired
    private UserControllerInterface userControllerInterface;

    @GetMapping("/feignUser/{userId}")
    public User getUserByFeign(@PathVariable("userId") int userId){
        User user = userControllerInterface.findUser(userId);
        return user;
    }

}
