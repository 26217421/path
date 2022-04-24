package com.wbw.pattern.relational.iterator;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-24 23:31
 */
public class MenuItem {
    private final String name;
    private final String description;
    private final boolean vegetable;
    private final float price;

    public MenuItem(String name, String description, boolean vegetable, float price) {
        this.name = name;
        this.description = description;
        this.vegetable = vegetable;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetable() {
        return vegetable;
    }
}
