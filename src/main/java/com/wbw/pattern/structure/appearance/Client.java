package com.wbw.pattern.structure.appearance;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-16 14:20
 */
public class Client{
    public static void main(String[] args) {
    Computer computer = new Computer();
    computer.start();
    System.out.println("=================");
    computer.shutDown();
    }

}
