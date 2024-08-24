package com.example.demo.service;

import com.example.demo.entity.PaidForm;
import com.example.demo.entity.PaidTotal;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface PaidService {
    //和mapper相呼应，有一个对应的方法

    List<PaidForm> getPaidList();
    List<PaidTotal> getTotalList();
    List<PaidForm> getPaidListByDate(String date);
    Boolean addPaid(String date, String type, Double price, String detaildescription, Integer tag, Timestamp createdate);
    Boolean updatePaid(Integer id, String date, String type, Double price, String detaildescription, Integer tag, Timestamp createdate);
    Boolean deletePaid(Integer id);
}
