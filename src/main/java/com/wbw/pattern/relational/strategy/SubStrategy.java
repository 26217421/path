package com.wbw.pattern.relational.strategy;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-19 2:04
 */
public class SubStrategy implements Strategy {
    /**
     * 计算方法
     *
     * @param a
     * @param b
     * @return 计算结果
     */
    @Override
    public int calc(int a, int b) {
        return a - b;
    }
}
