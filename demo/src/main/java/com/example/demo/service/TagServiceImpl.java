package com.example.demo.service;

import com.example.demo.entity.Tag;
import com.example.demo.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getTagList() {
        try{
            List<Tag> tagList= tagMapper.getTagList();
            return tagList;

        }catch (Exception e){
            //好像是 如果不throw的话，会报错。。。
            e.printStackTrace();
            throw e;
        }
    }
}
