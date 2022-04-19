package com.wbw.pattern.structure.flyweight;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-19 1:42
 */
public class Flyweight implements IFlyweight {
    private String id;
    public Flyweight(String id){
        this.id = id;
    }
    /**
     * 定义方法
     */
    @Override
    public void print() {
        System.out.println("Flyweight.id = " + getId() + " ...");
    }
    public String getId() {
        return id;
    }
}
