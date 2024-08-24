package com.example.demo.entity;

import java.io.Serializable;

public class Tag implements Serializable {
    private Integer paid_id;
    private String paid_type;

    public Integer getPaid_id(){
        return this.paid_id;
    }
    public String getPaid_type(){
        return this.paid_type;
    }
    public Tag(){}
}
