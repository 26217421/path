package com.wbw.pattern.structure.combination;

/**
 * 组合模式
 * @author wbw
 * @description: TODO
 * @date 2022-4-17 19:57
 */
public interface Component {
    public void add(Component c);
    public void remove(Component c);
    public Component getChild(int i);
    public void operation();
}
