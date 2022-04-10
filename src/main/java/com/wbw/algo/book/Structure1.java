package com.wbw.algo.book;


import org.junit.rules.Stopwatch;

import java.util.*;


/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-7 23:03
 */
public class Structure1 {

    /**
     * 括号匹配
     * @param formula 括号字符串
     * @return
     */
    public static boolean wellMatched(String formula) {
        String open = "([{", close = ")]}";
        Deque<String> stack = new ArrayDeque<>(formula.length());
        String[] chars = formula.split("");
        for (String ch:chars
             ) {
            if(open.contains(ch)) {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                if(open.indexOf(stack.peek()) != close.indexOf(ch)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 分析外星信号
     * @param signals 信号
     * @param k 和
     * @return 信号和等于k的区间个数
     */
    public static int offline(List<Integer> signals, int k) {

        return 0;
    }

    /**
     * kmp算法实现
     * @param H 源字符串
     * @param N 关键字符串
     * @return 匹配位置列表
     */
    public static List<Integer> kmpSearch(String H, String N) {
        int n = H.length(), m = N.length();
        char[] a = H.toCharArray();
        char[] b = N.toCharArray();
        int begin = 0, matched = 0;
        List<Integer> res = new ArrayList<>();
        //int[] pi = getPartialMatchNaive(N);
        int[] pi = getPartialMatch(N);
        System.out.println("pi: " + Arrays.toString(pi));
        while(begin <= n-m) {
            if(matched < m && a[begin + matched] == b[matched]) {
                ++matched;
                if(matched == m) {
                    res.add(begin);
                }
            } else {
                if(matched == 0) {
                    ++begin;
                } else {
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }

        return res;
    }

    /**
     * 利用kmp算法生成部分匹配表
     * @param N 关键字符串
     * @return
     */
    private static int[] getPartialMatch(String N) {
        long s = System.nanoTime();

        int m = N.length();
        char[] a = N.toCharArray();
        int[] pi = new int[m];
        int begin = 1, matched = 0;
        while (begin + matched < m) {
            if(a[begin + matched] == a[matched]) {
                ++matched;
                pi[begin + matched -1] = matched;
            } else {
                if(matched == 0) {
                    ++begin;
                } else {
                    begin += matched - pi[matched -1];
                    matched = pi [matched -1];
                }
            }
        }
        long b = System.nanoTime();
        System.out.println(b - s);
        return pi;
    }

    private static int[] getPartialMatchNaive(String N) {
        long s = System.nanoTime();
        int m = N.length();
        char[] a = N.toCharArray();
        int[] pi = new int[m];
        for (int begin = 1; begin < m; begin++) {
            for (int i = 0; i < m; i++) {
                if((begin + i) >= m) {
                    break;
                }
                if(a[begin + i] != a[i]) {
                    break;
                } else {
                    pi[begin + i] = Math.max(pi[begin + i], i+1);
                }
            }
        }
        long b = System.nanoTime();
        System.out.println(b - s);
        return pi;
    }

    /**
     * 既是字符串前缀又是后缀的字符串的最大长度
     * @param str 待查询字符串
     * @return 返回位置列表
     */
    public static List<Integer> getPrefixSuffix(String str) {
        List<Integer> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        int[] pi = getPartialMatch(str);
        System.out.println(Arrays.toString(pi));
        int k = chars.length;
        while(k > 0) {
            res.add(k);
            k = pi[k-1];
        }
        return res;
    }

    /**
     * 解决生成回文字符串问题的变形KMP算法
     * @param a
     * @param b
     * @return 返回既是a后缀又是b前缀的字符串长度
     */
    public static int maxOverLap(String a, String b) {
        int n = a.length(), m = a.length();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int[] pi = getPartialMatch(b);
        int begin = 0, matched = 0;
        while (begin < n) {
            if(matched < m && charsA[begin + matched] == charsB[matched]) {
                ++matched;
                if(begin + matched == n) {
                    return matched;
                }
            } else {
                if(matched == 0) {
                    ++begin;
                } else {
                    begin += matched - pi[matched - 1];
                    matched = pi[matched -1];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "sadasdasdasdda";
        String s2 = "dasda";
        System.out.println(kmpSearch(s1, s2));
        System.out.println(getPrefixSuffix("ababbaba"));
        System.out.println(maxOverLap("anon", "nona"));
    }
}
