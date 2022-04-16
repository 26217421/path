package com.wbw.pattern.structure.bridge;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-16 14:37
 */
public class AppStore implements Software {
    /**
     * app方法
     */
    @Override
    public void run() {
        System.out.println("run app store");
    }
}
