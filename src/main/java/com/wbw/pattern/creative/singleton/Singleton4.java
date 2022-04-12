package com.wbw.pattern.creative.singleton;

/**
 * 线程安全的懒汉式单例 —— 双重检查方式
 * @author wbw
 * @description: TODO
 * @date 2022-4-7 22:49
 */
public class Singleton4 {
    /**
     * volatile： 防止指令重排序
     */
    private volatile static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        // 第一次检查
        if(instance == null){
            // 只在最初几次会进入该同步块，提高效率
            synchronized(Singleton4.class){
                // 第二次检查
                if(instance == null){
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
