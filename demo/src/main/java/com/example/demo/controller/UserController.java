package com.example.demo.controller;

import com.example.demo.entity.LoginVo;
import com.example.demo.entity.ResultVo;
import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Autowired
    private UserServiceImpl userServer;

    @GetMapping("/users")
    public List<User> getUserList()
    {
        return userServer.getUserList();
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultVo loginStatus(HttpServletRequest req)
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        List<User> userlist = userServer.getUserList();
        for (User us: userlist){
            if (us.user_account.equals(username) && us.user_password.equals(password)){
                return new ResultVo(200, "登录成功", new LoginVo(us));
            }
        }
        return new ResultVo(201, "用户名/密码错误", "");
    }
}
