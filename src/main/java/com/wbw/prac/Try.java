package com.wbw.prac;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import com.wbw.java8.pojo.User;

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
        User user = new User();
        user.setEmail("123");
        user.setPassword("abc");
        User user1 = user;
        user1.setPassword("qwe");
        System.out.println(user);

    }

    public static String binary(byte[] bytes, int radix){
        return "0" + new  BigInteger(1, bytes).toString(radix);
    }



}
