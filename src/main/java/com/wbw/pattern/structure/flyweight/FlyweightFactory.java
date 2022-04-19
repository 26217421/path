package com.wbw.pattern.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-19 1:44
 */
public class FlyweightFactory {
    private Map<String, IFlyweight> flyweightMap = new HashMap<>();
    public IFlyweight getFlyweight(String str){
        IFlyweight flyweight = flyweightMap.get(str);
        if(flyweight == null){
            flyweight = new Flyweight(str);
            flyweightMap.put(str, flyweight);
        }
        return  flyweight;
    }
    public int getFlyweightMapSize() {
        return flyweightMap.size();
    }
}
