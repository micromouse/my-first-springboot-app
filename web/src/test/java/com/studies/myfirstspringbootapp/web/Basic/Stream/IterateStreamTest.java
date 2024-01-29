package com.studies.myfirstspringbootapp.web.Basic.Stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * Iterate流测试
 */
public class IterateStreamTest {
    /**
     * 使用iterate流生成斐波那契数列成功
     */
    @Test
    public void generate_fibonacci_series_success() {
        //从第11个元素开始，取10个
        new Fibonacci()
                .numbers()
                .skip(10)
                .limit(10)
                .forEach(System.out::println);
    }
}

/**
 * Stream.iterate() 产生的流的第一个元素是种子（iterate 方法的第一个参数），然
 * 后将种子传递给方法（iterate 方法的第二个参数）。方法运行的结果被添加到流（作为流
 * 的下一个元素），并被存储起来，作为下次调用iterate() 方法时的第一个参数，以此类
 * 推。
 */
class Fibonacci {
    int currentValue = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, seed -> {
            int nextValue = currentValue + seed;
            currentValue = seed;
            return nextValue;
        });
    }
}
