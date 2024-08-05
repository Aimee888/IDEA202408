package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //和mapper相呼应，有一个对应的方法
    List<User> getUserList();
}
