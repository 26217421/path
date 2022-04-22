package com.wbw.pattern.relational.observer;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-22 19:21
 */
public class User implements Observer {
    private final String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
