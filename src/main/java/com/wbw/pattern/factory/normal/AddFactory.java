package com.wbw.pattern.factory.normal;

import com.wbw.pattern.factory.opt.Operation;
import com.wbw.pattern.factory.opt.Add;

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
