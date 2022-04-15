package com.wbw.pattern.structure.decorator;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-15 3:30
 */
public class Soy extends Decorator {
    public Soy(AbstractDrink drink) {
        super(drink);
        setDes(" 豆浆 ");
        setPrice(1.5f);
    }
}
