package com.wbw.pattern.exp.reward;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 12:22
 */
public class StrategyContext {
    private static final Map<String, Strategy> REGISTER_MAP = new HashMap<>();

    /**
     * 注册策略
     * @param rewardType
     * @param strategy
     */
    public static void registerStrategy(String rewardType, Strategy strategy) {
        REGISTER_MAP.putIfAbsent(rewardType, strategy);
    }

    /**
     * 获取策略
     * @param rewardType
     * @return
     */
    public static Strategy getStrategy(String rewardType) {
        System.out.println(REGISTER_MAP.size());
        return REGISTER_MAP.get(rewardType);
    }


}
