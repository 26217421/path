package com.wbw.pattern.builder;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 22:32
 */
public class Director {
    private final Builder builder = new ConcreteBuilder();

    public Product getProductA() {
        // 设置不同的零件，产生不同的产品
        builder.setName("ProductA");
        builder.setVal(2);
        return builder.buildProduct();
    }

    public static void main(String[] args) {
        System.out.println(new Director().getProductA().toString());
        System.out.println(User.builder().id(1L).name("bob").build());
    }
}
