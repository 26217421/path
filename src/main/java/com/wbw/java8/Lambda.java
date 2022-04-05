package com.wbw.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-12-10 16:16
 */
public class Lambda {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort((a, b) -> b.compareTo(a));
        for (String a:names
             ) {
            System.out.println(a);
        }
    }
}
