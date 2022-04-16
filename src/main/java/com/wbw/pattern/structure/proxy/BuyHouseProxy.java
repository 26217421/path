package com.wbw.pattern.structure.proxy;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-16 14:05
 */
public class BuyHouseProxy implements BuyHouse {
    private final BuyHouse buyHouse;
    public BuyHouseProxy(final BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }
    /**
     * 买房
     */
    @Override
    public void buyHouse() {
        System.out.println("买房前准备");
        buyHouse.buyHouse();
        System.out.println("买房后装修");
    }
}
