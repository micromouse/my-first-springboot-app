package com.studies.myfirstspringbootapp.web.Basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 数组测试
 */
public class ArrayTest {
    /**
     * 数组初始化成功
     */
    @Test
    public void array_initialize_success() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;

        //可以将一个数组赋值给另一个数组，因为是引用赋值，所以对a2的修改也影响a1
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i] += 1;
        }

        //上面对a2的修改影响了a1
        StringBuilder value = new StringBuilder();
        for (int j : a1) {
            value.append(j);
        }
        Assertions.assertEquals("23456", value.toString());
    }

    /**
     * 通过Arrays.asList初始化了List成功
     */
    @Test
    public void initial_list_by_arrays_aslist_success() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertEquals(2, list.get(1));

        //修改元素
        list.set(1, 20);
        Assertions.assertEquals(20, list.get(1));

        /*
         * Runtime error： the underlying array cannot be resized.
         * list.add(6);
         */
    }

    /**
     * 在Arrays.asList初始化的List中添加新项时抛出UnsupportedOperationException异常
     * 底层实现是数组，没法调整大小
     */
    @Test
    public void throw_exception_when_add_item_in_arrays_aslist() {
        List<Integer> list = Arrays.asList(1, 2);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> list.add(3));
    }
}
