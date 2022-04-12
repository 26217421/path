package com.wbw.pattern.creative.singleton;

/**
 * 饿汉式单例
 * 线程不安全
 * @author wbw
 * @description: TODO
 * @date 2022-4-7 22:37
 */
public class Singleton1 {

    /**
     * 指向自己实例的私有静态引用，主动创建
     */
    private static Singleton1 instance = new Singleton1();

    /**
     * 私有的构造方法
     */
    private Singleton1(){}

    /**
     * 以自己实例为返回值的静态的公有方法，静态工厂方法
     */
    public static Singleton1 getInstance(){
        return instance;
    }
}

