package com.system.dao;

import com.system.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author:mazhiqiang
 * @Description:
 * @Date:Create in 18:00 2018-07-20
 * @Modified:
 */
@Mapper
@Repository
public interface UserMapper {

    User getUserById(@Param("id")Integer id);
}
