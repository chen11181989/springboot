package com.boot.module;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class Account implements Serializable{
    private int id ;
    @NotBlank
    @Length(min = 2 ,max = 10)
    private String name ;

    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Account() {
    }

    public Account(int id, String name, double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
}


