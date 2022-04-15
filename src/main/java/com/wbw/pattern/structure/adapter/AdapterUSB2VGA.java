package com.wbw.pattern.structure.adapter;

/**
 * 类适配器模式
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 18:07
 */
public class AdapterUSB2VGA extends UsbImpl implements VGA{
    @Override
    public void projection() {
        super.showPpt();
    }
}
