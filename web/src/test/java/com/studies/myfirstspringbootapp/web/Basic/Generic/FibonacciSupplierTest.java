package com.studies.myfirstspringbootapp.web.Basic.Generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 斐波那契Supplier测试
 */
public class FibonacciSupplierTest {
    /**
     * 生成斐波那契数列成功
     */
    @Test
    public void generate_fibonacci_series_success() {
        String fibonaccis = Stream.generate(new FibonacciSupplier())
                .limit(10)
                .map(n -> n + " ")
                .collect(Collectors.joining())
                .trim();
        Assertions.assertEquals("1 1 2 3 5 8 13 21 34 55", fibonaccis);
    }

    /**
     * forEach迭代斐波那契数列成功
     */
    @Test
    public void foreach_fibonacci_series_success() {
        for (Integer n : new FibonacciSupplier(20)) {
            System.out.printf("%d ", n);
        }
    }
}

/**
 * 斐波那契Supplier
 */
class FibonacciSupplier implements Supplier<Integer>, Iterable<Integer> {
    private int n;
    private int count = 0;

    public FibonacciSupplier() {
        this(0);
    }

    public FibonacciSupplier(int total) {
        this.n = total;
    }

    /**
     * 递增的获得数列值
     *
     * @return ：第n个元素的值
     */
    @Override
    public Integer get() {
        return getValue(count++);
    }

    private int getValue(int n) {
        if (n < 2) return 1;
        return getValue(n - 2) + getValue(n - 1);
    }

    /**
     * 迭代器
     *
     * @return ：forEach迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;

                //在匿名类中通过FibonacciSupplier.this引用父类FibonacciSupplier
                return FibonacciSupplier.this.get();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("未实现此方法");
            }
        };
    }
}
