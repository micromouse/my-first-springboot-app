package com.studies.myfirstspringbootapp.web.Basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

}
