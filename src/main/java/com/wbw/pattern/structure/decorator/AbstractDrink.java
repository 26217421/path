package com.wbw.pattern.structure.decorator;

/**
 * @author wbw
 * @date 2022-4-15 3:18
 */
public abstract class AbstractDrink {
    public String des;
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 计算费用的抽象方法
     * @return 费用
     */
    public abstract float cost();

}
