package com.example.demo.controller;

import com.example.demo.entity.PaidForm;
import com.example.demo.entity.PaidTotal;
import com.example.demo.entity.ResultVo;
import com.example.demo.service.PaidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8082", "http://192.168.8.102:8080"})
public class PaidController {
    @Autowired
    private PaidServiceImpl paidServer;

    @GetMapping("/getpaidlist")
    public ResultVo getPaidList()
    {
        List<PaidForm> paidList = paidServer.getPaidList();
        return new ResultVo(200, "", paidList);
    }

    @GetMapping("/gettotallist")
    public ResultVo getTotalList()
    {
        System.err.println("=======================");
        List<PaidTotal> paidTotalList = paidServer.getTotalList();
        return new ResultVo(200, "", paidTotalList);
    }

    @PostMapping("/getpaidlistbydate")
    public ResultVo getPaidListByDate(@RequestBody PaidForm paidForm)
    {
        String date = paidForm.getDate();
        date = date.replaceAll("undefined", "%");
        System.err.println(date);
        List<PaidForm> paidList = paidServer.getPaidListByDate(date);
        return new ResultVo(200, "", paidList);
    }

    @PostMapping("/addpaid")
    public ResultVo addPaid(@RequestBody PaidForm paidForm)
    {
        System.err.println(paidForm.getDate());
        System.err.println(paidForm.getType());
        System.err.println(paidForm.getPrice());
        System.err.println(paidForm.getDetaildescription());
        System.err.println(paidForm.getTag());
        String date = paidForm.getDate();
        String type = paidForm.getType();
        Double price = paidForm.getPrice();
        String detaildescription = paidForm.getDetaildescription();
        Integer tag = paidForm.getTag();
        Timestamp create_date = new Timestamp((new Date()).getTime());
        Boolean flag = paidServer.addPaid(date, type, price, detaildescription, tag, create_date);
        if (flag){
            return new ResultVo(200, "", true);
        }
        else{
            return new ResultVo(201, "", false);
        }
    }

    @PostMapping("/updatepaid")
    public ResultVo updatePaid(@RequestBody PaidForm paidForm)
    {
//        System.err.println(paidForm.getId());
//        System.err.println(paidForm.getDate());
//        System.err.println(paidForm.getType());
//        System.err.println(paidForm.getPrice());
//        System.err.println(paidForm.getDetaildescription());
//        System.err.println(paidForm.getTag());
        Integer id = paidForm.getId();
        String date = paidForm.getDate();
        String type = paidForm.getType();
        Double price = paidForm.getPrice();
        String detaildescription = paidForm.getDetaildescription();
        Integer tag = paidForm.getTag();
        Timestamp create_date = new Timestamp((new Date()).getTime());
        Boolean flag = paidServer.updatePaid(id, date, type, price, detaildescription, tag, create_date);
        if (flag){
            return new ResultVo(200, "", true);
        }
        else{
            return new ResultVo(201, "", false);
        }
    }

    @PostMapping("/deletepaid")
    public ResultVo deletePaid(@RequestBody PaidForm paidForm)
    {
        System.err.println(paidForm.getId());
        Integer id = paidForm.getId();
        Boolean flag = paidServer.deletePaid(id);
        if (flag){
            return new ResultVo(200, "", true);
        }
        else{
            return new ResultVo(201, "", false);
        }
    }
}
