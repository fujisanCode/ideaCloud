package com.rai.serviceprovider1.dao;

import com.rai.serviceprovider1.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}