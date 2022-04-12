package com.wbw.pattern.creative.builder;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 22:33
 */
public class ConcreteBuilder extends Builder {
    @Override
    public void setVal(Integer val) {
        /**
         * 产品类内部的逻辑
         * 实际存储的值是 val + 100
         */
        this.val = val + 100;
    }

    @Override
    public Product buildProduct() {
        // 这块还可以写特殊的校验逻辑
        return new Product(name, val);
    }
}
