package com.example.nicolas.pourjulien.model;

import java.io.Serializable;

public class NotSoSimple extends Simple implements Serializable {

    private float price = 0;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + " / " + price;
    }
}
