package com.example.demo.entity;


import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Slf4j
public class TUser {
    @NotNull
    private int id;
    @Min(3)
    private String str1;
    private String str2;
    private String str3;

    public TUser(int id, String str1, String str2, String str3) {
        this.id = id;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }
}
