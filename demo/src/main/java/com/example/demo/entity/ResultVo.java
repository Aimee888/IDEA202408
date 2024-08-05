package com.example.demo.entity;

public class ResultVo {
    //相应码
    private Integer code;
    //信息
    private String message;
    //返回数据
    private Object data;

    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }

    public Object getData(){
        return this.data;
    }

    public ResultVo(Integer Code, String Message, Object Data){
        this.code = Code;
        this.message = Message;
        this.data = Data;
    }

}
