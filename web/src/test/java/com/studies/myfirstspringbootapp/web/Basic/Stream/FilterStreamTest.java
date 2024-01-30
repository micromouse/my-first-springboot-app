package com.studies.myfirstspringbootapp.web.Basic.Stream;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

/**
 * 筛选流测试
 */
public class FilterStreamTest {
    /**
     * 生成质数流成功
     */
    @Test
    public void generate_prime_stream_success() {
        System.out.printf("从1开始的10个质数：%n");
        this.numbers()
                .limit(10)
                .forEach(n -> System.out.printf("%d ", n));

        System.out.printf("%n跳过从1开始的前10个质数后的10个质数：%n");
        this.numbers()
                .skip(10)
                .limit(10)
                .mapToObj(n -> n + ",")
                .forEach(n -> System.out.printf("%s ", n));
    }

    /**
     * 生成质数LongStream
     *
     * @return : 质数LongStream
     */
    private LongStream numbers() {
        return LongStream.iterate(2, i -> i + 1)
                .filter(this::isPrime);
    }

    /**
     * 判断数n是不是质数
     *
     * @param n ：数
     * @return ：n是否质数
     */
    private boolean isPrime(long n) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }
}
