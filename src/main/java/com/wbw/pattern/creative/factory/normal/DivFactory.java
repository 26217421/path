package com.wbw.pattern.creative.factory.normal;

import com.wbw.pattern.creative.factory.opt.Div;
import com.wbw.pattern.creative.factory.opt.Operation;

/**
 * @author wbw
 * @date 2022-4-11 1:53
 */
public class DivFactory implements Factory {
    /**
     * 创建需要的计算对象
     *
     * @return 计算对象
     */
    @Override
    public Operation createOperation() {
        System.out.println("除法操作");
        return new Div();
    }
}
