package com.wbw.pattern.structure.combination;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-17 19:58
 */
public class Leaf implements Component {
    private String name;


    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {
    }

    @Override
    public void remove(Component c) {
    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + "：被访问！");
    }
}

