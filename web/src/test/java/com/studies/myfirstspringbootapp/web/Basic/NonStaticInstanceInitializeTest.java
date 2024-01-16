package com.studies.myfirstspringbootapp.web.Basic;

import org.junit.jupiter.api.Test;

/**
 * 非静态实例初始化测试
 */
public class NonStaticInstanceInitializeTest {
    /**
     * 测试非静态实例初始化
     */
    @Test
    public void test() {
        System.out.println("Inside main()");
        new Mugs();
        System.out.println("new Mugs() completed");
        new Mugs(1);
        System.out.println("new Mugs(1) completed");
        /*
        结果输出顺序：
        Inside main()
        Mug(1)
        Mug(2)
        mug1 & mug2 initialized
        Mugs()
        new Mugs() completed
        Mug(1)
        Mug(2)
        mug1 & mug2 initialized
        Mugs(1)
        new Mugs(1) completed
        ----------------------------
        从输出看出，实例初始化子句是在两个构造器之前执行的。
         */
    }
}

class Mug {
    Mug(int marker) {
        System.out.printf("Mug(%s)%n", marker);
    }
}

class Mugs {
    Mug mug1;
    Mug mug2;
    /*
    实例初始化子句没有静态成员初始化子句前面的static关键字
    无论执行哪个构造器，实例初始化子句都会先执行
     */
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("mug1 & mug2 initialized");
    }

    Mugs() {
        System.out.println("Mugs()");
    }

    Mugs(int i) {
        System.out.printf("Mugs(%s)%n", i);
    }
}