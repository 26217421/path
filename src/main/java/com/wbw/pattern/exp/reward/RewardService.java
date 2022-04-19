package com.wbw.pattern.exp.reward;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 12:24
 */
public class RewardService {


    public void issueReward(String rewardType, Object... params) {
        Strategy strategy = StrategyContext.getStrategy(rewardType);
        strategy.issue(params);
    }


}
