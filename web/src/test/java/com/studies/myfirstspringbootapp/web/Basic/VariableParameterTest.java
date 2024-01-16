package com.studies.myfirstspringbootapp.web.Basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 可变参数测试
 */
public class VariableParameterTest {
    /**
     * Object类型可变参数测试成功
     */
    @Test
    public void object_variable_parameter_success() {
        Assertions.assertEquals("", do_object_variable_parameter());
        Assertions.assertEquals("1 1.0 1.1", do_object_variable_parameter(1, 1.0f, 1.1d));
        Assertions.assertEquals("one two three", do_object_variable_parameter("one", "two", "three"));
        Assertions.assertEquals("1 2 3 4", do_object_variable_parameter((Object[]) new Integer[]{1, 2, 3, 4}));
    }

    /**
     * String类型可变参数测试成功
     */
    @Test
    public void string_variable_parameter_success() {
        Assertions.assertEquals("100 is one two three", do_string_variable_parameter(100, "one", "two", "three"));
        Assertions.assertEquals("100 is ", do_string_variable_parameter(100));
    }

    /**
     * 执行可变参数
     *
     * @param args ：可变参数集合
     * @return ：可变参数字符串
     */
    private String do_object_variable_parameter(Object... args) {
        StringBuilder builder = new StringBuilder();
        for (Object object : args) {
            builder.append(object).append(" ");
        }
        return builder.toString().trim();
    }

    /**
     * 可以参数是字符串类型
     *
     * @param age ：年龄
     * @param args ：字符串类型可变参数
     * @return ：字符串可变参数结果
     */
    private String do_string_variable_parameter(int age, String... args) {
        StringBuilder builder = new StringBuilder();
        for (Object object : args) {
            builder.append(object).append(" ");
        }
        return String.format("%s is %s", age, builder.toString().trim());
    }
}
