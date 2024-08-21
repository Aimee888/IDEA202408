package com.example.demo.service;

import com.example.demo.entity.PaidForm;
import com.example.demo.entity.User;
import com.example.demo.mapper.PaidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


@Repository
public class PaidServiceImpl implements PaidService {
    @Autowired
    private PaidMapper paidMapper;

    @Override
    public List<PaidForm> getPaidList() {
        try{
            List<PaidForm> paidList= paidMapper.getPaidList();
            return paidList;

        }catch (Exception e){
            //好像是 如果不throw的话，会报错。。。
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Boolean addPaid(String date, String type, Double price, String detaildescription, Integer tag, Timestamp createdate) {
        try{
            return paidMapper.addPaid(date, type, price, detaildescription, tag, createdate);

        }catch (Exception e){
            //好像是 如果不throw的话，会报错。。。
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Boolean updatePaid(Integer id, String date, String type, Double price, String detaildescription, Integer tag, Timestamp createdate) {
        try{
            return paidMapper.updatePaid(id, date, type, price, detaildescription, tag, createdate);

        }catch (Exception e){
            //好像是 如果不throw的话，会报错。。。
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Boolean deletePaid(Integer id) {
        try{
            return paidMapper.deletePaid(id);

        }catch (Exception e){
            //好像是 如果不throw的话，会报错。。。
            e.printStackTrace();
            throw e;
        }
    }
}
