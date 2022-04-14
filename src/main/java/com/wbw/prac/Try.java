package com.wbw.prac;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author wbw
 */
public class Try {
    private static final String S = "001111110100000110000100010100011101000001011001010000000010100100101100001000111110111100011100001111000001011011001000";
    public static void main(String[] args) {

        byte[] bytes = "wangbowen123456".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        System.out.println(bytes[0]);
        System.out.println(binary(bytes, 2));
        System.out.println(HexBin.encode(bytes));

    }

    public static String binary(byte[] bytes, int radix){
        return "0" + new  BigInteger(1, bytes).toString(radix);
    }



}
