package com.wbw.pattern.creative.factory.opt;


/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-10 23:54
 */
public class Div implements Operation {
    /**
     * 除法操作
     *
     * @param numberA 操作数A
     * @param numberB 操作数B
     * @return 计算结果
     * @throws Exception
     */
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        if (numberB == 0) {
            throw new Exception("除数不能为0！");
        }
        return numberA / numberB;
    }
}
