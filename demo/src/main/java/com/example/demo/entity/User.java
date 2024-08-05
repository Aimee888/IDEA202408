package com.example.demo.entity;

public class User {
    public String user_account;
    public String user_password;

    public String getUser_account(){
        return this.user_account;
    }

    public String getUser_password(){
        return this.user_password;
    }

    public User(String User_account, String User_password){
        this.user_account = User_account;
        this.user_password = User_password;
    }
}
