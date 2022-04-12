package com.wbw.pattern.creative.factory.normal;

import com.wbw.pattern.creative.factory.opt.Add;
import com.wbw.pattern.creative.factory.opt.Operation;

/**
 * @author wbw
 * @date 2022-4-11 1:47
 */
public class AddFactory implements Factory {
    /**
     * 创建需要的计算对象
     *
     * @return 计算对象
     */
    @Override
    public Operation createOperation() {
        System.out.println("加法运算");
        return new Add();    }
}
