package com.system.service;

import com.system.dao.UserMapper;
import com.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:mazhiqiang
 * @Description:
 * @Date:Create in 18:08 2018-07-20
 * @Modified:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }
}
