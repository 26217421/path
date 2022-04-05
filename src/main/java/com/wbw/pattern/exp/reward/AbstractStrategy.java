package com.wbw.pattern.exp.reward;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 12:28
 */
public abstract class AbstractStrategy {
    /**
     * 类注册方法
     */
    public void register() {
        StrategyContext.registerStrategy(getClass().getSimpleName(), (Strategy) this);
    }
}
