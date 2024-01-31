package com.studies.myfirstspringbootapp.web.Basic.Exceptions;

import org.junit.jupiter.api.Test;

/**
 * 自动关闭测试
 */
public class AutoCloseableTest {
    /**
     * 使用try-with-resources自动关闭资源
     */
    @Test
    public void use_try_with_resources_success() {
        try (
                First first = new First();
                Second second = new Second()
        ) {
            System.out.println("自动关闭");
        }
        /*
         * 输出顺序如下：
         * ----------------------
         * Creating First
         * Creating Second
         * 自动关闭
         * Closing Second
         * Closing First
         */
    }
}

class Reporter implements AutoCloseable {
    final String name;

    public Reporter() {
        name = getClass().getSimpleName();
        System.out.printf("Creating %s%n", name);
    }

    @Override
    public void close() {
        System.out.printf("Closing %s%n", name);
    }
}

class First extends Reporter {
}

class Second extends Reporter {
}
