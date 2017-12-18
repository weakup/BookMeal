package com.example.lisiyan.bookmeal.model;

import java.io.Serializable;

/**
 * Created by lisiyan on 2017/12/17.
 */

public class FoodModel implements Serializable {

    private int id;
    private String name;
    private int count;
    private int money;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
