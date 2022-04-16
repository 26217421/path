package com.wbw.pattern.structure.bridge;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-16 14:49
 */
public abstract class Phone {
    protected Software software;

    public void setSoftware(Software software) {
        this.software = software;
    }

    /**
     * 运行方法
     */
    public abstract void run();
}
