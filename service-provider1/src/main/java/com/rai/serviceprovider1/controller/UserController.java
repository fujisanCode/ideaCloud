package com.rai.serviceprovider1.controller;

import com.rai.serviceprovider1.dao.UserMapper;
import com.rai.serviceprovider1.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
  @Autowired
  private UserMapper userMapper;

  @GetMapping("/findUser/{uId}")
  public User findUser(@PathVariable int uId) {
    log.info("findUser para -> {}.", uId);
    User getUser = userMapper.selectByPrimaryKey(uId);
    log.info("findUser return -> {}.", getUser);
    return getUser;
  }
}
