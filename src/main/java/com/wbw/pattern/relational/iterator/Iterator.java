package com.wbw.pattern.relational.iterator;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-24 23:22
 */
public interface Iterator {
    /**
     * 返回是否还有下一个元素
     * @return 是否还有下一个元素
     */
    public boolean hasNext();

    /**
     * 返回下一个元素
     * @return 下一个元素
     */
    public Object next();
}
