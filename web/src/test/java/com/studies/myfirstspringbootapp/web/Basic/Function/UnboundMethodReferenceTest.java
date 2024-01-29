package com.studies.myfirstspringbootapp.web.Basic.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 未绑定方法引用测试
 */
public class UnboundMethodReferenceTest {
    /**
     * 测试未绑定方法引用成功
     */
    @Test
    public void test_success() {
        /*
         * MakeString makeString = X::f;
         * 这里尝试使用方法引用 X::f 去实现 MakeString 接口。但是，X::f 是一个实例方法，需要一个 X 类型的对象来调用。
         * 然而，MakeString 的 make 方法没有参数，所以无法提供一个 X 对象给 f 方法。这就是为什么编译器报告
         * “Non-static method cannot be referenced from a static context”的原因。
         */
        X x = new X();
        TransformX transformX = X::f;
        Assertions.assertEquals("X::f() admin 20", transformX.transform(x, "admin", 20));
        Assertions.assertEquals("X::f() admin 20", x.f("admin", 20));

        MakeString makeString = X::h;
        Assertions.assertEquals("X::h()", makeString.make());
    }
}

class X {
    String g() {
        return "x::g";
    }

    String f(String name, int age) {
        return String.format("X::f() %s %d", name, age);
    }

    static String h() {
        return "X::h()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x, String name, int age);
}

