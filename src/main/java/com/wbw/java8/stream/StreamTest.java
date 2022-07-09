package com.wbw.java8.stream;


import com.wbw.java8.pojo.Dish;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * @author wbw
 * @date 2022-7-5 3:44
 */
public class StreamTest {
    List<Dish> menu = asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );

    List<Dish> specialMenu = asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));

    @Test
    public void testStream() {
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNames);

        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(toList());
        System.out.println(squares);

        List<Integer> numbers1 = asList(1, 2, 3);
        List<Integer> numbers2 = asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j}))
                        .collect(toList());
        pairs.forEach(a -> System.out.println(Arrays.toString(a)));


    }

    @Test
    public void testNumericalValue() {
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(1);

        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );
        pythagoreanTriples.forEach(a -> System.out.println(Arrays.toString(a)));
        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .mapToObj(
                                                b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                                        .filter(t -> t[2] % 1 == 0));

    }
    @Test
    public void streamOnlyOne() {
        List<String> title = asList("Modern", "Java", "In", "Action");
        Stream<String> s = title.stream();

        s.forEach(System.out::println);
    }

    @Test
    public void testStreamMatchesAndFind() {
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        isHealthy = menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println(isHealthy);
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));
        List<Integer> someNumbers = asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(n -> n * n)
                        .filter(n -> n % 3 == 0)
                        .findFirst();
    }
    @Test
    public void testStreamReduce() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(6, Integer::sum);
        System.out.println(sum);
        Optional<Integer> sum1 = numbers.stream().reduce(Integer::sum);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);
        long count0 = menu.stream().count();
    }

    @Test
    public void testStreamCollect() {
        Comparator<Dish> dishCaloriesComparator =
                comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream()
                .collect(maxBy(dishCaloriesComparator));
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));
        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);
        int totalCalories1 = menu.stream().collect(reducing(
                0, Dish::getCalories, Integer::sum));
        Optional<Dish> mostCalorieDish1 =
                menu.stream().collect(reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
    }

    @Test
    public void testStreamGroup() {
        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                } ));
        dishesByCaloricLevel.forEach((a, b) -> System.out.println(a + ":" + b));
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                //Java9
                                filtering(dish -> dish.getCalories() > 500, toList())));
        caloricDishesByType.forEach((a, b) -> System.out.println(a + ":" + b));

        Map<Dish.Type, Set<String>> dishNamesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
                                        toSet())));
        dishNamesByType.forEach((a, b) -> System.out.println(a + ":" + b));

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                } )
                        )
                );
        dishesByTypeCaloricLevel.forEach((a, b) -> System.out.println(a + "=" + b));
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));
        typesCount.forEach((a, b) -> System.out.println(a + "=" + b));
        Map<Dish.Type, Dish> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        mostCaloricByType.forEach((a, b) -> System.out.println(a + "=" + b));
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT; },
                                toCollection(HashSet::new) )));
    }

    @Test
    public void testStreamPartition() {
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));
        mostCaloricPartitionedByVegetarian.forEach((a, b) -> System.out.println(a + "=" + b));
    }
    public enum CaloricLevel { DIET, NORMAL, FAT }





}
