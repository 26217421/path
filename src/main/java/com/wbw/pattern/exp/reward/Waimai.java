package com.wbw.pattern.exp.reward;

import com.wbw.pattern.exp.reward.util.WaimaiRequest;
import com.wbw.pattern.exp.reward.util.WaimaiService;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 2:50
 */
public class Waimai extends AbstractStrategy implements Strategy {
    private static final Waimai instance = new Waimai();
    private WaimaiService waimaiService;
    private Waimai() {
        register();
    }
    public static Waimai getInstance() {
        return instance;
    }
    /**
     * @param params 入参
     */
    @Override
    public void issue(Object... params) {
        WaimaiRequest request = new WaimaiRequest();
        // 构建入参
        request.setWaimaiReq(params);
        waimaiService.issueWaimai(request);
    }

}
