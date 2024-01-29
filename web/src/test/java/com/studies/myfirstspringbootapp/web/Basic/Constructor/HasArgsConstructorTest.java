package com.studies.myfirstspringbootapp.web.Basic.Constructor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 有参构造函数测试
 */
public class HasArgsConstructorTest {
    /**
     * 测试有参构造函数
     */
    @Test
    public void test() {
        ChineseGinkgo chineseGinkgo = new ChineseGinkgo("admin");
        Assertions.assertNotNull(chineseGinkgo);
        /*
         * 输出顺序为：
         * 有参构造函数初始化，
         * 除非显式的调用基类有参构造函数，否则基类有参构造函数不会被调用
         * 不管是否显示调用基类无参构造函数，基类无参构造函数都会被调用
         * Botany.Constructor()
         * Ginkgo.Constructor(admin)
         * ChineseGinkgo.Constructor(admin)
         */
    }
}

/// <summary>
/// ['bɑːtəni],植物
/// </summary>
class Botany {
    public Botany() {
        System.out.println("Botany.Constructor()");
    }

    public Botany(String name) {
        System.out.printf("Botany.Constructor(%s)%n", name);
    }
}

/// <summary>
/// ['ɡɪŋkoʊ],银杏
/// </summary>
class Ginkgo extends Botany {
    public Ginkgo(String name) {
        /*
         * 因为Botany有无参构造函数，所以这里可以不用明确调用super(name)
         */
        System.out.printf("Ginkgo.Constructor(%s)%n", name);
    }
}

/// <summary>
/// 中国银杏
/// </summary>
class ChineseGinkgo extends Ginkgo {
    public ChineseGinkgo(String name) {
        /*
         * 如果注释掉super(name)
         * 因为Ginkgo没有无参构造函数，编译器将报下列错误
         * There is no default constructor available in 'com.studies.myfirstspringbootapp.web.Basic.Constructor.Ginkgo'
         */
        super(name);
        System.out.printf("ChineseGinkgo.Constructor(%s)%n", name);
    }
}