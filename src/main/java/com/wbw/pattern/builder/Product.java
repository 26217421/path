package com.wbw.pattern.builder;

/**
 * @author wbw
 * @date 2022-4-5 22:34
 */
public class Product {
    private String name;

    private Integer val;

    Product(String name, Integer val) {
        this.name = name;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Product is " + name + " value is " + val;
    }
}
