package com.system.controller;

/**
 * @Author:mazhiqiang
 * @Description:
 * @Date:Create in 16:03 2018-07-18
 * @Modified:
 */

import com.ggstar.util.ip.IpHelper;
import com.sun.org.apache.bcel.internal.generic.RET;
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

import java.math.BigDecimal;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private IpHelper ipHelper;
    @RequestMapping(value = "/dologin" ,method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user){
        LOG.info("USERNAME:"+user.getUsername());
        if("mzq".equals(user.getUsername())){
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    @ResponseBody
    public User getById(Integer userId){

        return userService.getUserById(userId);
    }

    @RequestMapping(value = "getIp",method = RequestMethod.GET)
    @ResponseBody
    public String getIp(String ip){
        long start = System.nanoTime();
        LOG.info("START:"+start);
        String region = IpHelper.findRegionByIp(ip);
        long end = System.nanoTime();
        LOG.info("END:"+end);
        LOG.info("TIME:"+(end-start)+"ns");
        LOG.info("TIME:"+new BigDecimal((end - start )/1000000.00).setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue()+"ms");

        return region;
    }

}
