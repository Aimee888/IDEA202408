package com.example.demo.mapper;

import com.example.demo.entity.Tag;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagMapper {
    @Select("select * from tag")
    List<Tag> getTagList();
}
