package com.wbw.pattern.creative.exp.reward;

import com.wbw.pattern.creative.exp.reward.util.HotelRequest;
import com.wbw.pattern.creative.exp.reward.util.HotelService;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 12:13
 */
public class Hotel extends AbstractStrategy implements Strategy {
    private static final Hotel instance = new Hotel();
    private HotelService hotelService;
    private Hotel() {
        register();
    }
    public static Hotel getInstance() {
        return instance;
    }
    @Override
    public void issue(Object... params) {
        HotelRequest request = new HotelRequest();
        request.addHotelReq(params);
        hotelService.sendPrize(request);
    }
}
