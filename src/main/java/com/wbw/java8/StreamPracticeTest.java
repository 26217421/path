package com.wbw.java8;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-2-22 12:36
 */
public class StreamPracticeTest {
    @Test
    public void testStream(){
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        //sorted 不会对 stringCollection 做出任何改变
        System.out.println(stringCollection);

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }
    @Test
    public void testStreamSort(){
        List<String> values = getList();

        long t0 = System.nanoTime();
        long count = values.stream().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.printf("顺序流排序耗时: %d ms%n", millis);
    }

    @Test
    public void testParallelStream(){
        List<String> values = getList();
        // 纳秒
        long t0 = System.nanoTime();

        long count = values.parallelStream().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.printf("并行流排序耗时: %d ms%n", millis);

    }

    public List<String> getList(){
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }
}
