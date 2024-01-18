package com.studies.myfirstspringbootapp.web.Constructor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 无参构造函数测试
 */
public class NoArgsConstructorTest {
    /**
     * 测试无参构造函数
     */
    @Test
    public void test() {
        ChineseCat chineseCat = new ChineseCat();
        Assertions.assertNotNull(chineseCat);
        /*
         * 输出顺序为：
         * 无参构造函数实例化，即使没有显式的调用基类无参构造函数，编译器也会自动调用
         * Animal.Constructor()
         * Cat.Constructor()
         * ChineseCat.Constructor()
         */
    }
}

class Animal {
    public Animal() {
        System.out.println("Animal.Constructor()");
    }
}

class Cat extends Animal {
    public Cat() {
        System.out.println("Cat.Constructor()");
    }
}

class ChineseCat extends Cat {
    public ChineseCat() {
        System.out.println("ChineseCat.Constructor()");
    }
}