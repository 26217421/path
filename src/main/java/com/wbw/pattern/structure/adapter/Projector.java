package com.wbw.pattern.structure.adapter;

import org.junit.Test;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-14 22:12
 */
public class Projector<T> {
    public void projection(T t) {
        if (t instanceof VGA) {
            System.out.println("开始投影");
            VGA v;
            v = (VGA) t;
            v.projection();
        } else {
            System.out.println("接口不匹配，无法投影");
        }
    }

    @Test
    public void test2(){
        //通过适配器创建一个VGA对象，这个适配器实际是使用的是USB的showPPT（）方法
        VGA a=new AdapterUSB2VGA();
        //进行投影
        Projector p1=new Projector();
        p1.projection(a);
    }


}
