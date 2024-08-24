package com.example.demo.controller;

import com.example.demo.entity.ResultVo;
import com.example.demo.entity.Tag;
import com.example.demo.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8082", "http://192.168.8.102:8080"})
public class CommonController {
    @Autowired
    private TagServiceImpl tagServer;

    @GetMapping("/gettaglist")
    public ResultVo getTagList()
    {
        List<Tag> paidList = tagServer.getTagList();
        return new ResultVo(200, "", paidList);
    }
}
