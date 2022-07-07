package com.wbw.java8.stream;

import com.wbw.java8.pojo.Trader;
import com.wbw.java8.pojo.Transaction;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author wbw
 * @date 2022-7-6 0:41
 */
public class pracStreamTest {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @Test
    public void answer(){
        transactions.stream()
                .filter(a->a.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        transactions.stream()
                .map(a->a.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(a->a.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        String reduce = transactions.stream()
                .map(a -> a.getTrader().getName())
                .sorted()
                .distinct()
                .reduce("", (a, b) -> a + b);
        System.out.println(reduce);
        boolean anyMatch = transactions.stream().anyMatch(a -> a.getTrader().getCity().equals("Milan"));
        System.out.println(anyMatch);
        Integer reduce1 = transactions.stream()
                .filter(a -> a.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(reduce1);
        Integer reduce2 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println(reduce2);
        Optional<Transaction> first = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findFirst();
        System.out.println(first);
    }

    @Test
    public void testCustomizeCollector() {

        partitionPrimesWithCustomCollector(1000).forEach((a, b) -> System.out.println(a + "=" + b));
    }
    public Map<Boolean, List<Integer>>
    partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }
    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(this::isPrime));
    }
    public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
