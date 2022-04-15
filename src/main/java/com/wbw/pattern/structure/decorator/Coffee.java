package com.wbw.pattern.structure.decorator;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-15 3:20
 */
public class Coffee extends AbstractDrink {

    /**
     * 计算费用的抽象方法
     * @return 费用
     */
    @Override
    public float cost() {
        return super.getPrice();    }
}
