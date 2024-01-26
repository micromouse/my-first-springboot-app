package com.studies.myfirstspringbootapp.web.FunctionPrograming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;
import java.util.function.IntToDoubleFunction;

/**
 * 构造函数引用测试
 */
public class ConstructorreferenceTest {
    /**
     * 测试构造函数引用成功
     */
    @Test
    public void test_success() {
        IMakeNoArgs makeNoArgs = Dog::new;
        IMake1Arg make1Arg = Dog::new;
        IMake2Args make2Args = Dog::new;

        Dog dogNoArgs = makeNoArgs.make();
        Dog dog1Arg = make1Arg.make("admin");
        Dog dog2Args = make2Args.make("admin", 20);

        Assertions.assertEquals("stray-1", dogNoArgs.name + dogNoArgs.age);
        Assertions.assertEquals("admin-1", dog1Arg.name + dog1Arg.age);
        Assertions.assertEquals("admin20", dog2Args.name + dog2Args.age);
    }
}

class Dog {
    String name;
    int age = -1;

    Dog() {
        name = "stray";
    }

    Dog(String name) {
        this.name = name;
    }

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface IMakeNoArgs {
    Dog make();
}

interface IMake1Arg {
    Dog make(String name);
}

interface IMake2Args {
    Dog make(String name, int age);
}