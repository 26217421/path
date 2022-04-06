package com.wbw.algo.book;

import java.util.LinkedList;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-5 23:00
 */
public class Joseph {
    public static void solve(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n;i++){
            list.offerLast(i+1);
        }
        while(list.size()> 2) {
            list.removeFirst();
            for (int i = 0; i < m-1; i++) {
                list.add(list.poll());
            }
        }
        System.out.println(list);

    }

    public static int f(int n, int m) {
        if(n == 1) {
            return n;
        }
        return (f(n - 1, m) + m - 1) % n + 1;
    }
    public static void main(String[] args) {
        System.out.println(f(40,3));
        solve(40, 3);
    }
}
