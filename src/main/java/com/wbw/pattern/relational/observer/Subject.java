package com.wbw.pattern.relational.observer;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-22 19:18
 */
public interface Subject {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
