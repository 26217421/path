package com.wbw.pattern.structure.decorator;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-15 3:29
 */
public class Chocolate extends Decorator {
    public Chocolate(AbstractDrink drink) {
        super(drink);
        setDes(" 巧克力 ");
        setPrice(3.0f);
    }
}
