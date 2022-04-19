package com.wbw.pattern.relational.strategy;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-19 2:05
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calc(int a, int b) {
        return strategy.calc(a, b);
    }

}
