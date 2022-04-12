package com.wbw.pattern.creative.factory.normal;

import com.wbw.pattern.creative.factory.opt.Operation;

/**
 * 工厂接口
 * <p>工厂方法模式克服了简单工厂会违背开-闭原则的缺点，又保持了封装对象创建过程的优点。
 * 但工厂方法模式的缺点是每增加一个产品类，就需要增加一个对应的工厂类，增加了额外的开发量。</>
 * @author wbw
 * @date 2022-4-11 0:28
 */
public interface Factory {
    /**
     * 创建需要的计算对象
     * @return 计算对象
     */
    public Operation createOperation() ;
}
