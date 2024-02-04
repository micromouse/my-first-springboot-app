package com.studies.myfirstspringbootapp.web.Basic.Generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 擦除类型测试
 */
public class ErasedTypeTest {
    /**
     * 擦除泛型类型等价,本例都是ArrayList
     */
    @Test
    public void erased_type_equivalence_success() {
        Class<?> class1 = new ArrayList<Integer>().getClass();
        Class<?> class2 = new ArrayList<String>().getClass();
        System.out.printf("class1.getName(): %s%n", class1.getName());
        System.out.printf("class2.getName(): %s%n", class2.getName());
        Assertions.assertEquals(class1, class2);
    }

    /**
     * 成功获得泛型类型参数
     */
    @Test
    public void get_generic_type_parameters_success() {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        /*
         * 根据JDK 文档，Class.getTypeParameters() “返回一个TypeVariable 对象数组，
         * 表示泛型声明中声明的类型参数…” 这暗示你可以发现这些参数类型。但是正如本
         * 例中输出所示，你只能看到用作参数占位符的标识符，这并非有用的信息。
         */
        Assertions.assertEquals("[E]", Arrays.toString(list.getClass().getTypeParameters()));
        Assertions.assertEquals("[K, V]", Arrays.toString(map.getClass().getTypeParameters()));
    }
}

class Erased<T> {
    public void f(Object arg) {
        if (arg instanceof T) {

        }

        T var = new T();
        T[] arrays1 = new T[10];
        T[] arrays2 = (T[]) new Object[10];
    }
}
