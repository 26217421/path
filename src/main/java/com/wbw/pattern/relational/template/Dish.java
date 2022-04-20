package com.wbw.pattern.relational.template;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-19 23:00
 */
public abstract class Dish {
    /**
     * 具体的整个过程
     */
    protected void doDish(){
        this.preparation();
        this.doing();
        this.carriedDishes();
    }
    /**
     * 备料
     */
    public abstract void preparation();
    /**
     * 做菜
     */
    public abstract void doing();
    /**
     * 上菜
     */
    public abstract void carriedDishes ();

}
