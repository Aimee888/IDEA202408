package com.example.demo.entity;

import java.io.Serializable;

public class PaidTotal implements Serializable {
    private String date;
    private Double food_price;
    private Double normal_price;
    private Double clothing_price;
    private Double travel_price;
    private Double medical_price;
    private Double car_price;
    private Double favor_price;
    private Double total_price;

    public String getDate(){
        return this.date;
    }
    public void setDate(String Date){
        date = Date;
    }
    public Double getFood_price(){
        return this.food_price;
    }
    public void setFood_price(Double Food_price){
        this.food_price = Food_price;
    }
    public Double getNormal_price(){
        return this.normal_price;
    }
    public void setNormal_price(Double Normal_price){
        this.normal_price = Normal_price;
    }
    public Double getClothing_price(){
        return this.clothing_price;
    }
    public void setClothing_price(Double Clothing_price){
        this.clothing_price = Clothing_price;
    }
    public Double getTravel_price(){
        return this.travel_price;
    }
    public void setTravel_price(Double Travel_price){
        this.travel_price = Travel_price;
    }
    public Double getMedical_price(){
        return this.medical_price;
    }
    public void setMedical_price(Double Medical_price){
        this.medical_price = Medical_price;
    }
    public Double getCar_price(){
        return this.car_price;
    }
    public void setCar_price(Double Car_price){
        this.car_price = Car_price;
    }
    public Double getFavor_price(){
        return this.favor_price;
    }
    public void setFavor_price(Double Favor_price){
        this.favor_price = Favor_price;
    }
    public Double getTotal_price(){
        return this.total_price;
    }
    public void setTotal_price(Double Total_price){
        this.total_price = Total_price;
    }

    public PaidTotal(){
    }
}
