package com.example.demo.entity;

import java.io.Serializable;

public class PaidForm implements Serializable {
    private Integer id;
    private String date;
    private String type;
    private double price;
    private String detaildescription;
    private Integer tag;

    public Integer getId(){
        return this.id;
    }
    public String getDate(){
        return this.date;
    }
    public String getType(){
        return this.type;
    }
    public double getPrice(){
        return this.price;
    }
    public String getDetaildescription(){
        return this.detaildescription;
    }
    public Integer getTag(){
        return this.tag;
    }
    public PaidForm(){
    }
}
