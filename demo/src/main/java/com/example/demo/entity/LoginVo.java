package com.example.demo.entity;

import java.io.Serializable;

public class LoginVo implements Serializable {
    private  User user;

    public User getUser(){
        return this.user;
    }
    public LoginVo(User user_obj){
        this.user = user_obj;
    }
}
