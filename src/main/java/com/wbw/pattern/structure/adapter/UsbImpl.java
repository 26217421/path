package com.wbw.pattern.structure.adapter;

/**
 * @author wbw
 * @date 2022-4-14 22:11
 */
public class UsbImpl implements Usb {
    /**
     * 展示方法
     */
    @Override
    public void showPpt() {
        System.out.println("PPT内容演示");
    }
}
