package com.example.demo.service;

import com.example.demo.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {
    List<Tag> getTagList();
}
