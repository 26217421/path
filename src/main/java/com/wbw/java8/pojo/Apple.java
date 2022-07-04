package com.wbw.java8.pojo;

import java.awt.*;

/**
 * @author wbw
 * @date 2022-7-3 3:46
 */
public class Apple {
    public int weight;
    public String country;
    public Color color;
    public Apple(int weight, String country){
        this.weight = weight;
        this.country = country;
    }

    public int getWeight() {
        return weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", country='" + country + '\'' +
                '}';
    }
}
