package com.wbw.pattern.factory.simple;

import com.wbw.pattern.factory.opt.Operation;

/**
 * @author wbw
 * @date 2022-4-11 0:05
 */
public class Client {
    public static void main(String[] args) throws Exception {

        Operation add = EasyFactory.createOperation("+");
        Operation sub = EasyFactory.createOperation("-");
        Operation mul = EasyFactory.createOperation("*");
        Operation div = EasyFactory.createOperation("/");

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
        System.out.println(mul.getResult(1, 1));
        System.out.println(div.getResult(1, 1));
    }
}
