package com.wbw.prac;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author wbw
 */
public class Try {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);list.add(1);list.add(1);list.add(1);
        for (int a:list
             ) {
            System.out.println(a);
        }
        System.out.println();
        list.forEach(System.out::println);
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));
        // true
        boolean a = predicate.negate().test("foo");


    }
}
