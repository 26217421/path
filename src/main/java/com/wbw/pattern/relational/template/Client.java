package com.wbw.pattern.relational.template;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-19 23:34
 */
public class Client {
    public static void main(String[] args) {
        Dish eggsWithTomato = new EggsWithTomato();
        eggsWithTomato.doDish();

        System.out.println("-----------------------------");

        Dish bouilli = new Bouilli();
        bouilli.doDish();

    }
}
