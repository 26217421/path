package com.wbw.java8;

import com.google.common.collect.Lists;
import com.wbw.java8.function.BufferedReaderProcessor;
import com.wbw.java8.pojo.Apple;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.awt.Color.*;
import static java.util.Comparator.comparing;


/**
 * @author wbw
 * @version 1.0
 * @date 2021-12-10 16:16
 */
public class Lambda {

    @Test
    public void testLambda1(){
        process(()-> System.out.println("This is awesome!"));
        try {
            String result
                    = processFile((BufferedReader br) -> br.readLine() + br.readLine());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(12, "China"));
        inventory.add(new Apple(12, "Canada"));
        inventory.add(new Apple(10, "China"));

        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry));
        System.out.println(inventory);

    }
    @Test
    public void testPredicate() {
        List<String> listOfStrings = Lists.newArrayList("ss", " ", "a", "as", "","qw");

        Predicate<String> nonEmptyStringPredicate = (s) -> !(s.trim().isEmpty());
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(nonEmpty);
        nonEmpty.sort(comparing(String::length));
        System.out.println(nonEmpty);

        Predicate<Apple> redApple = (apple -> RED.equals(apple.getColor()));
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> redAndHeavyApple =
                redApple.and(apple -> apple.getWeight() > 150);
        Predicate<Apple> redAndHeavyAppleOrGreen =
                redApple.and(apple -> apple.getWeight() > 150)
                        .or(apple -> GREEN.equals(apple.getColor()));
    }
    @Test
    public void testConsumer() {
        forEach(
                Arrays.asList(1,2,3,4,5),
                System.out::println
        );
    }
    @Test
    public void testFunction() {
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                String::length
        );
        System.out.println(l);

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);
        System.out.println(result);

        f = x -> x + 1;
        g = x -> x * 2;
        h = f.compose(g);
        result = h.apply(1);
        System.out.println(result);
    }

    public <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T t: list) {
            result.add(f.apply(t));
        }
        return result;
    }
    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T t: list) {
            if(p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);
        }
    }

    private String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader("data.txt")
        )) {
            return bufferedReaderProcessor.process(br);
        }
    }

    public String processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(
                new FileReader("data.txt")
        )){
            return br.readLine();
        }
    }

    public void process(Runnable runnable) {
        runnable.run();
    }
}
