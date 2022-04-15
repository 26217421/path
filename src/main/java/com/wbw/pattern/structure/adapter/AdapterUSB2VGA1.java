package com.wbw.pattern.structure.adapter;

/**
 * 对象适配器模式
 * @author wbw
 * @description: TODO
 * @date 2022-4-15 0:26
 */
public class AdapterUSB2VGA1 implements VGA {
    Usb u = new UsbImpl();
    /**
     * 输出方法
     */
    @Override
    public void projection() {
        u.showPpt();
    }
}
