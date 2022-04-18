package com.wbw.pattern.structure.combination;

import java.util.ArrayList;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-17 20:01
 */
public class Composite implements Component {
    private ArrayList<Component> children = new ArrayList<Component>();

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }
    @Override
    public Component getChild(int i) {
        return children.get(i);
    }
    @Override
    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }

}
