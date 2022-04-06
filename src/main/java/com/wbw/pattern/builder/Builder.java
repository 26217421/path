package com.wbw.pattern.builder;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 22:33
 */
public abstract class Builder {
    protected Integer val;

    protected String name;

    /**
     * 设置产品不同部分，以获得不同的产品
     */
    public abstract void setVal(Integer val);

    /**
     * 设置名字 公用方法
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 建造产品
     *
     */
    public abstract Product buildProduct();
}
