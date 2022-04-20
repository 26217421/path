package com.wbw.pattern.relational.template;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-19 23:33
 */
public class Bouilli extends Dish{
    /**
     * 备料
     */
    @Override
    public void preparation() {
        System.out.println("切猪肉和土豆。");
    }

    /**
     * 做菜
     */
    @Override
    public void doing() {
        System.out.println("将切好的猪肉倒入锅中炒一会然后倒入土豆连炒带炖。");
    }

    /**
     * 上菜
     */
    @Override
    public void carriedDishes() {
        System.out.println("将做好的红烧肉盛进碗里端给客人吃。");
    }
}
