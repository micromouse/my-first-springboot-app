package com.studies.myfirstspringbootapp.web.Basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 字符串测试
 */
public class StringTest {
    /**
     * 字符串相加成功
     */
    @Test
    public void add_string_success() {
        String s = "x,y,z ";
        int x = 0, y = 1, z = 2;

        //字符串+数字
        Assertions.assertEquals("x,y,z 012", s + x + y + z);
        Assertions.assertEquals("0 1", x + " " + y);

        //级联操作
        s += "(summed) = ";
        Assertions.assertEquals("x,y,z (summed) = 3", s + (x + y + z));

        //Integer.toString()方法的简写
        Assertions.assertEquals("0", "" + x);
    }
}
