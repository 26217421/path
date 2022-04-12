package com.wbw.pattern.creative.exp.reward;

import com.wbw.pattern.creative.exp.reward.util.FoodRequest;
import com.wbw.pattern.creative.exp.reward.util.FoodService;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 12:20
 */
public class Food extends AbstractStrategy implements Strategy {
    private static final Food INSTANCE = new Food();
    private FoodService foodService;

    private Food() {
        register();
    }
    @Override
    public void issue(Object... params) {
        FoodRequest request = new FoodRequest(params);
        foodService.payCoupon(request);
    }
    public static Food getInstance() {
        return INSTANCE;
    }
}
