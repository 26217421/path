package com.wbw.pattern.factory.opt;

/**
 * @author wbw
 * @date 2022-4-10 23:54
 */
public class Mull implements Operation {
    /**
     * 乘法操作
     *
     * @param numberA 操作数A
     * @param numberB 操作数B
     * @return 计算结果
     * @throws Exception
     */
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA * numberB;
    }
}
