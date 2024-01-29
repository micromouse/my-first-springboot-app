package com.studies.myfirstspringbootapp.web.Basic.Stream;


import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * 与Supplier<T>兼容流测试
 */
public class BubbleStreamTest {
    @Test
    public void generate_supplier_compatibility_stream_success() {
        Stream.generate(Bubble::bubble)
                .limit(3)
                .forEach(System.out::println);
    }
}

class Bubble {
    final int i;

    public Bubble(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return String.format("Bubble(%s)", i);
    }

    static int count = 0;

    /**
     * 实例化一个新Bubble
     */
    public static Bubble bubble() {
        return new Bubble(count++);
    }
}