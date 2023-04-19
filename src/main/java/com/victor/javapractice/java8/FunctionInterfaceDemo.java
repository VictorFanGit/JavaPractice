package com.victor.javapractice.java8;

import com.victor.javapractice.java8.entity.Product;
import org.junit.Test;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * 函数式接口
 */
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
//Predicate接口是输入一个参数，返回布尔值。我们通过and方法组合两个Predicate条件，判断是否值大于0并且是偶数
        Predicate<Integer> positiveNumber = i -> i > 0;
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        assertTrue(positiveNumber.and(evenNumber).test(2));

//Consumer接口是消费一个数据。我们通过andThen方法组合调用两个Consumer，输出两行abcdefg
        Consumer<String> println = System.out::println;
        println.andThen(println).accept("abcdefg");
        println.accept("abc");

//Function接口是输入一个数据，计算后输出一个数据。我们先把字符串转换为大写，然后通过andThen组合另一个Function实现字符串拼接
        Function<String, String> upperCase = String::toUpperCase;
        Function<String, String> duplicate = s -> s.concat(s);
        assertThat(upperCase.andThen(duplicate).apply("test"), is("TESTTEST"));

//Supplier是提供一个数据的接口。这里我们实现获取一个随机数
        Supplier<Integer> random = ()-> ThreadLocalRandom.current().nextInt();
        System.out.println(random.get());

//BinaryOperator是输入两个同类型参数，输出一个同类型参数的接口。这里我们通过方法引用获得一个整数加法操作，通过Lambda表达式定义一个减法操作，然后依次调用
        BinaryOperator<Integer> add = Integer::sum;
        BinaryOperator<Integer> subtraction = (a, b) -> a - b;
        assertThat(subtraction.apply(add.apply(1, 2), 3), is(0));
    }


    private Map<Long, Product> cache = new ConcurrentHashMap<>();

    private Product getProductAndCacheCool(Long id) {
        return  cache.computeIfAbsent(id, i -> //当Key不存在的时候提供一个Function来代表根据Key获取Value的过程
                Product.getData().stream()
                        .filter(p -> p.getId().equals(i)) //过滤
                        .findFirst() //找第一个，得到Optional<Product>
                        .orElse(null)); //如果找不到Product，则使用null
    }

    @Test
    public void coolCache()
    {
        getProductAndCacheCool(1L);
        getProductAndCacheCool(100L);

        System.out.println(cache);
        assertThat(cache.size(), is(1));
        assertTrue(cache.containsKey(1L));
    }


    @Test
    public void test2() {
        boolean b = IntStream.rangeClosed(1, 10)
                .allMatch(Objects::nonNull);
        System.out.println(b);
    }

}
