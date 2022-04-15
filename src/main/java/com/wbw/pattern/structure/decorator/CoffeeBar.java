package com.wbw.pattern.structure.decorator;

/**
 * @author wbw
 * @date 2022-4-15 3:31
 */
public class CoffeeBar {
    public static void main(String[] args) {
        // 1. 点一份 LongBlack
        AbstractDrink order = new LongBlack();
        System.out.println("费用1=" + order.getPrice());
        System.out.println("描述=" + order.getDes());

        // 2. order 加入一份牛奶
        order = new Milk(order);
        System.out.println("order 加入一份牛奶 费用 = " + order.cost());
        System.out.println("order 加入一份牛奶 描述 = " + order.getDes());

        // 3. order 加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入一份巧克力 费用 = " + order.cost());
        System.out.println("order 加入一份巧克力 描述 = " + order.getDes());

        // 4. order 加入2份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入2份巧克力 费用 = " + order.cost());
        System.out.println("order 加入2份巧克力 描述 = " + order.getDes());

        System.out.println("======================================");

        AbstractDrink order2 = new Decaf();
        System.out.println("order2 无因咖啡 费用 = " + order2.cost());
        System.out.println("order2 无因咖啡 描述 = " + order2.getDes());

        order2 = new Milk(order2);
        System.out.println("order2 无因咖啡 加入一份牛奶 费用 = " + order2.cost());
        System.out.println("order2 无因咖啡 加入一份牛奶 描述 = " + order2.getDes());
    }
}
