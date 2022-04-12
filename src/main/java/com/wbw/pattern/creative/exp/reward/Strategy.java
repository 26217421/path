package com.wbw.pattern.creative.exp.reward;

/**
 * @author wbw
 * @description: 策略接口
 * @date 2022-4-5 2:46
 */
public interface Strategy {
    /**
     * 奖励方法
     * @param params 入参
     */
    void issue(Object ... params);
}
