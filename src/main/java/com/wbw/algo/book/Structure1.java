package com.wbw.algo.book;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


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

    public static void main(String[] args) {

    }
}
