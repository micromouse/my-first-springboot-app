package com.studies.myfirstspringbootapp.web.Basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 字面量常量测试
 */
public class LiteralTest {
    /**
     * 执行字面量常量测试成功
     */
    @Test
    public void do_Literal_test_success() {
        //16进制，小写
        int x1 = 0x2f;
        Assertions.assertEquals("101111", Integer.toBinaryString(x1));

        //16进制，大写
        int x2 = 0X2F;
        Assertions.assertEquals("101111", Integer.toBinaryString(x1));

        //8进制,前导0
        int x3 = 0177;
        Assertions.assertEquals("1111111", Integer.toBinaryString(x3));

        //16进制(可以用下划线分隔，方便阅读)，最大的char类型
        char x4 = 0xff_ff;
        Assertions.assertEquals("1111111111111111", Integer.toBinaryString(x4));

        //16进制，最大的byte类型
        byte x5 = 0x7f;
        Assertions.assertEquals("1111111", Integer.toBinaryString(x5));

        //16进制，最大的short类型
        short x6 = 0x7fff;
        Assertions.assertEquals("111111111111111", Integer.toBinaryString(x6));

        //long类型
        long x7 = 200L;
        long x8 = 200l;
        Assertions.assertEquals(x7, x8);

        //float类型
        float x9 = 1F;
        float x10 = 1f;
        Assertions.assertEquals(x9, x10);

        //double类型
        double x11 = 1D;
        double x12 = 1d;
        Assertions.assertEquals(x11, x12);

        //二进制字面量常量,byte
        byte b1 = (byte) 0b00110101;
        Assertions.assertEquals("110101", Integer.toBinaryString(b1));

        //二进制字面量常量，short
        short b2 = (short) 0B0010111110101111;
        Assertions.assertEquals("10111110101111", Integer.toBinaryString(b2));

        //二进制字面量常量(可以用下划线分隔，方便阅读)，long
        long b3 = 0b0010_1111_1010_1111_1010_1111_1010_1111;
        Assertions.assertEquals("101111101011111010111110101111", Long.toBinaryString(b3));
    }
}
