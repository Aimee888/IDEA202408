package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    //然后做一些数据库的对应操作，这次是查询操作
    @Select("select * from user")
    List<User> getUserList();
}
