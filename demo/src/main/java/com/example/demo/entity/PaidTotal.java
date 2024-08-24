package com.example.demo.entity;

import java.io.Serializable;

public class PaidTotal implements Serializable {
    private String date;
    private Integer food_price;
    private Integer normal_price;
    private Integer clothing_price;
    private Integer travel_price;
    private Integer medical_price;
    private Integer car_price;
    private Integer favor_price;
    private Integer total_price;

    public String getDate(){
        return this.date;
    }
    public Integer getFood_price(){
        return this.food_price;
    }
    public Integer getNormal_price(){
        return this.normal_price;
    }
    public Integer getClothing_price(){
        return this.clothing_price;
    }
    public Integer getTravel_price(){
        return this.travel_price;
    }
    public Integer getMedical_price(){
        return this.medical_price;
    }
    public Integer getCar_price(){
        return this.car_price;
    }
    public Integer getFavor_price(){
        return this.favor_price;
    }
    public Integer getTotal_price(){
        return this.total_price;
    }

    public PaidTotal(){
    }
}
