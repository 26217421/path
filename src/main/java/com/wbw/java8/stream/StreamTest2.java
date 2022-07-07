package com.wbw.java8.stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author wbw
 * @date 2022-7-7 17:17
 */
public class StreamTest2 {
    @Test
    public void testparallelStream() {
        Long reduce = Stream.iterate(1L, i -> i + 1)
                .limit(10000)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(reduce);
    }
}
