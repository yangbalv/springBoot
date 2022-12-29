package com.springboot.live_comm.utils;


import com.springboot.personalLearning.stream.collection.iterable.MyIterable;
import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtil {


    public static void main(String[] args) {

    }


    @Test
    public void testDoubleMaoHao() {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "jkl", "jkl");
        System.out.println(strings.stream().filter(str -> aBoolean2(str)).count());
        String[] strings1 = new String[10];
        MyIterable<String> myIterable = new MyIterable<>();
        for (String s : myIterable) {
//            StreamUtil::aVoid2;
        }
//        System.out.println(strings.stream().filter(StreamUtil::aVoid2).count());
    }

    public static boolean aBoolean() {
        return true;
    }

    public static boolean aBoolean2(String s) {
        System.out.println("aBoolean2: " + s);
        return true;
    }

    public static boolean aBoolean3(String s, String s2) {
        System.out.println("aBoolean2: " + s);
        System.out.println("aBoolean2: " + s2);
        return true;
    }

    public static void aVoid() {
        System.out.println("aVoid： nothing");
    }

    public static void aVoid2(String s) {
        System.out.println("aVoid2: " + s);
    }

//中间管道测试***********

    /**
     * 功能描述:根据条件过滤集合数据
     *
     * @return : void
     */
    @Test
    public void filter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
    }

    /**
     * 功能描述:去除集合中重复数据
     *
     * @return : void
     */
    public void distinct() {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "jkl", "jkl");
        List<String> distincted = strings.stream().distinct().collect(Collectors.toList());
        System.out.println(distincted);
    }

    /**
     * 功能描述:指定获取集合前x条数据，重新构造一个新的集合
     *
     * @return : void
     */
    public void limit() {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "jkl", "jkl");
        List<String> limited = strings.stream().limit(3).collect(Collectors.toList());
        System.out.println(limited);
    }

    /**
     * 功能描述:排除集合前x条数据，把后面的数据重新构造一个新的集合
     *
     * @return : void
     */
    public void skip() {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "jkl", "jkl");
        List<String> skiped = strings.stream().skip(3).collect(Collectors.toList());
        System.out.println(skiped);
    }

    /**
     * 功能描述:对集合中所有元素统一处理
     *
     * @return : void
     */
    public void map() {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "jkl", "jkl");
        List<String> mapped = strings.stream().map(str -> str + "-itcast").collect(Collectors.toList());
        System.out.println(mapped);
    }


    /**
     * 功能描述:对集合中所有元素统一处理
     *
     * @return : void
     */
    public void flatMap() {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "jkl", "jkl");
        Stream<String> stringStream = strings.stream().map(x -> x);
        Stream<String> stringStream1 = strings.stream().flatMap(x -> Arrays.asList(x.split(" ")).stream());
    }

    /**
     * 功能描述 : 对集合进行排序
     *
     * @return : void
     */
    public void sorted() {
        List<String> strings1 = Arrays.asList("abc", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        List<String> strings2 = Arrays.asList("张三", "李四", "王五", "赵柳", "张哥", "李哥", "王哥");
        List<Integer> strings3 = Arrays.asList(10, 2, 30, 22, 1, 0, -9);
        List<String> sorted1 = strings1.stream().sorted().collect(Collectors.toList());
        List<String> sorted2 = strings2.stream().sorted(Collections.reverseOrder(Collator.getInstance(Locale.CHINA))).collect(Collectors.toList());
        List<Integer> sorted3 = strings3.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted1);
        System.out.println(sorted2);
        System.out.println(sorted3);
    }


    /**
     * 方法一
     * 功能描述:  通过使用map、flatMap把字符串转换为字符输出对比区别
     *
     * @return : void
     */
    public void flatMap2Map() {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "jkl", "jkl");
        final Stream<Character> flatMap = strings.stream().flatMap(StreamUtil::getCharacterByString);
        flatMap.forEach(System.out::println);
        //----------------------------------------------
        final Stream<Stream<Character>> mapStream = strings.stream().map(StreamUtil::getCharacterByString);
        //mapStream.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        mapStream.forEach(stream -> {
            stream.forEach(character -> {
                System.out.println(character);
            });
        });

    }


    /**
     * 功能描述:字符串转换为字符流
     *
     * @param str
     * @return : java.util.stream.Stream<java.lang.Character>
     */
    public static Stream<Character> getCharacterByString(String str) {
        List<Character> characterList = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            characterList.add(character);
        }
        return characterList.stream();
    }
//终止管道测试

    /**
     * 功能描述 : 判断集合中是否至少存在一个元素满足条件
     *
     * @return : void
     */
    public void anyMatch() {
        List<String> strings = Arrays.asList("abc", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        boolean b = strings.stream().anyMatch(s -> s == "abc");
        System.out.println(b);
    }


    /**
     * 功能描述 : 判断集合中是否所有元素都满足条件
     *
     * @return : void
     */
    public void allMatch() {
        List<String> strings = Arrays.asList("abc", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        boolean b = strings.stream().allMatch(s -> s == "abc");
        System.out.println(b);
    }

    /**
     * 功能描述 : 判断集合中是否所有元素都不满足条件
     *
     * @return : void
     */
    public void noneMatch() {
        List<String> strings = Arrays.asList("abc", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        boolean b = strings.stream().noneMatch(s -> s == "abc");
        System.out.println(b);
    }

    /**
     * 功能描述 : 返回当前流中任意元素
     *
     * @return : void
     */
    public void findAny() {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        Optional<String> any = strings.stream().findAny();
        if (any.isPresent()) System.out.println(any.get());
    }


    /**
     * 功能描述 : 返回当前流中第一个元素
     *
     * @return : void
     */
    public void findFirst() {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        Optional<String> first = strings.stream().findFirst();
        if (first.isPresent()) System.out.println(first.get());
    }


    /**
     * 功能描述 : 遍历流
     *
     * @return : void
     */
    public void foreach() {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        strings.stream().forEach(s -> System.out.println(s));
    }


    /**
     * 功能描述 : 流转换为其他形式
     *
     * @return : void
     */
    public void collect() {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        Set<String> set = strings.stream().collect(Collectors.toSet());
        List<String> list = strings.stream().collect(Collectors.toList());
        Map<String, String> map = strings.stream().collect(Collectors.toMap(v -> v.concat("_name"), v1 -> v1, (v1, v2) -> v1));
        System.out.println(set);
        System.out.println(list);
        System.out.println(map);
    }


    /**
     * 功能描述 : 将流中元素反复结合起来，得到一个值
     *
     * @return : void
     */
    public void reduce() {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        //reduce方法一
        Optional<String> reduce1 = strings.stream().reduce((acc, item) -> {
            return acc + item;
        });
        //reduce方法二
        String reduce2 = strings.stream().reduce("itcast", (acc, item) -> {
            return acc + item;
        });
        //reduce方法三
        ArrayList<String> reduce3 = strings.stream().reduce(
                new ArrayList<String>(),
                new BiFunction<ArrayList<String>, String, ArrayList<String>>() {
                    @Override
                    public ArrayList<String> apply(ArrayList<String> acc, String item) {
                        acc.add(item);
                        return acc;
                    }
                },
                new BinaryOperator<ArrayList<String>>() {
                    @Override
                    public ArrayList<String> apply(ArrayList<String> acc, ArrayList<String> item) {
                        return acc;
                    }
                }
        );
        if (reduce1.isPresent()) System.out.println(reduce1.get());
        System.out.println(reduce2);
        System.out.println(reduce3);
    }

    /**
     * 功能描述 : 返回流中元素总数
     *
     * @return : void
     */
    public void count() {
        List<String> strings = Arrays.asList("cv", "abd", "aba", "efg", "abcd", "jkl", "jkl");
        long count = strings.stream().count();
        System.out.println(count);
    }


}
