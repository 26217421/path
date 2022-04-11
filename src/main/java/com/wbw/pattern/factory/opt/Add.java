package com.wbw.pattern.factory.opt;

import com.wbw.pattern.factory.opt.Operation;

/**
 * @author wbw
 * @date 2022-4-10 23:51
 */
public class Add implements Operation {
    /**
     * 加法操作
     *
     * @param numberA 操作数A
     * @param numberB 操作数B
     * @return 计算结果
     * @throws Exception
     */
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA + numberB;
    }
}
