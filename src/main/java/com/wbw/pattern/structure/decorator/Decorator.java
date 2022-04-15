package com.wbw.pattern.structure.decorator;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-15 3:27
 */
public class Decorator extends AbstractDrink{
    private AbstractDrink drink;

    public Decorator(AbstractDrink drink) { // 组合
        this.drink = drink;
    }

    /**
     * 计算费用的抽象方法
     * @return 费用
     */
    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        // drink.getDes()  输出被装饰者的信息
        return super.des + " " + getPrice() + " && " + drink.getDes();
    }

}
