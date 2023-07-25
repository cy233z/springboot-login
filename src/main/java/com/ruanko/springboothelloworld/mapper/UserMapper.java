package com.ruanko.springboothelloworld.mapper;

import com.ruanko.springboothelloworld.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username} and password=#{password}")
    User getInfo(@Param("username") String username, @Param("password") String password);

    @Insert("insert into user(username,password)values(#{username},#{password})")
    void setInfo(@Param("username") String username, @Param("password") String password);
}
