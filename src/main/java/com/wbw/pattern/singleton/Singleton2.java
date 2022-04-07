package com.wbw.pattern.singleton;

/**
 * 懒汉式单例
 * @author wbw
 * @description: TODO
 * @date 2022-4-7 22:38
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    /**
     * 以自己实例为返回值的静态的公有方法，静态工厂方法
     */
    public static Singleton2 getInstance() {
        // 被动创建，在真正需要使用时才去创建
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
