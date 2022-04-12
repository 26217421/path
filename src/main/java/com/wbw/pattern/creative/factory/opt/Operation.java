package com.wbw.pattern.creative.factory.opt;

/**
 * @author wbw
 * @date 2022-4-10 23:49
 */
public interface Operation {
    /**
     * 计算方法
     * @param numberA 操作数A
     * @param numberB 操作数B
     * @return 计算结果
     * @throws Exception
     */
    double getResult(double numberA, double numberB) throws Exception;

}
