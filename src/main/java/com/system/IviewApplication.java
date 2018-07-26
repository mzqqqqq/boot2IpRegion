package com.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
 * @Author:mazhiqiang
 * @Description:
 * @Date:Create in 16:02 2018-07-18
 * @Modified:
 */
@SpringBootApplication
@ComponentScan(basePackages = "com")
@MapperScan("com.*.dao")
public class IviewApplication {

    public static void main(String[] args){
        SpringApplication.run(IviewApplication.class);
    }

}
