package com.studies.myfirstspringbootapp.web.Basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 数字转换测试
 */
public class CastNumberTest {
    /**
     * 一般数字转换测试
     */
    @Test
    public void normal_cast_success() {
        double above = 1.7d, blow = 1.4d;
        float fabove = 1.7f, fblow = 1.4f;

        Assertions.assertEquals(1, (int) above);
        Assertions.assertEquals(1, (int) blow);
        Assertions.assertEquals(1, (int) fabove);
        Assertions.assertEquals(1, (int) fblow);
    }

    /**
     * Math.round四舍五入转换
     */
    @Test
    public void round_cast_success() {
        double above = 0.7d, blow = 0.4d;
        float fabove = 0.7f, fblow = 0.4f;

        Assertions.assertEquals(1, Math.round(above));
        Assertions.assertEquals(0, Math.round(blow));
        Assertions.assertEquals(1, Math.round(fabove));
        Assertions.assertEquals(0, Math.round(fblow));
    }
}
