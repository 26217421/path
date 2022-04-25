package com.wbw.pattern.relational.chain;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-25 22:54
 */
public abstract class Handler {
    protected Handler chain;

    public void next(Handler handler){
        this.chain = handler;
    }

    /**
     * 处理方法
     * @param member 实体
     */
    public abstract void doHandle(Member member);

}
