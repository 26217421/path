package com.wbw.java8;

/**
 * @author wbw
 */
public interface Formula {
    /**
     * 计算
     */
    double calculate(int a);

    /**
     * 求平方根
     * @return 平方根
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

class Test0{
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));     // 100.0
        System.out.print(formula.sqrt(16));

    }
}