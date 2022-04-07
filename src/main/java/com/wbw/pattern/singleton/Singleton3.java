package com.wbw.pattern.singleton;

/**
 * 线程安全的懒汉式单例 —— 内部类方
 * @author wbw
 * @description: TODO
 * @date 2022-4-7 22:44
 */
public class Singleton3 {
    /**
     * 静态私有内部类
     * <p>
     * 原理：虚拟机会保证一个类的类构造器<clinit>()在多线程环境中被正确的加锁、同步，
     * 如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的类构造器<clinit>()，
     * 其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕。
     * 特别需要注意的是，在这种情形下，其他线程虽然会被阻塞，但如果执行<clinit>()方法的那条线程退出后，
     * 其他线程在唤醒之后不会再次进入/执行<clinit>()方法，因为 在同一个类加载器下，一个类型只会被初始化一次。</>
     */
    private static class InnerClass {
        private final static Singleton3 instance = new Singleton3();
    }

    private Singleton3(){

    }

    public static Singleton3 getInstance(){
        return InnerClass.instance;
    }

}
