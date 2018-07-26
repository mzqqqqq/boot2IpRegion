package com.system.controller;

/**
 * @Author:mazhiqiang
 * @Description:
 * @Date:Create in 16:03 2018-07-18
 * @Modified:
 */

import com.system.config.CorsConfig;
import com.system.model.User;
import com.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/dologin" ,method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user){
        LOG.info("USERNAME:"+user.getUsername());
        if("mzq".equals(user.getUsername())){
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/getById")
    @ResponseBody
    public User getById(Integer userId){

        return userService.getUserById(userId);
    }
}
