package com.wbw.pattern.structure.decorator;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-15 3:30
 */
public class Milk extends Decorator {
    public Milk(AbstractDrink drink) {
        super(drink);
        setDes(" 牛奶 ");
        setPrice(2.0f);
    }
}
