package com.wbw.pattern.creative.factory.simple;

import com.wbw.pattern.creative.factory.opt.*;

/**
 * 简单工厂类
 * <p>容易导致简单工厂类很庞大臃肿、耦合性高，而且增加、删除某个子类对象的创建都需要打开简单工厂类来进行修改代码也违反了开-闭原则。</>
 * @author wbw
 * @description: TODO
 * @date 2022-4-10 23:55
 */
public class EasyFactory {

    /**
     * 根据字符串创建相应的对象
     * @param name 操作字符串
     * @return
     */
    public static Operation createOperation(String name) {
        Operation operationObj = null;
        switch (name) {
            case "+":
                operationObj = new Add();
                break;
            case "-":
                operationObj = new Sub();
                break;
            case "*":
                operationObj = new Mull();
                break;
            case "/":
                operationObj = new Div();
                break;
            default:
                break;
        }
        return operationObj;
    }

}
