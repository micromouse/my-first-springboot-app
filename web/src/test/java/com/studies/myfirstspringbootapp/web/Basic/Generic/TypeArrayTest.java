package com.studies.myfirstspringbootapp.web.Basic.Generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

/**
 * 泛型数组测试
 */
public class TypeArrayTest {
    /**
     * 使用带类型Token的泛型数组成功
     */
    @Test
    public void use_generic_array_with_type_token_success() {
        GenericArrayWithTypeToken<Integer> integerGenericArrayWithTypeToken =
                new GenericArrayWithTypeToken<>(Integer.class, 10);
        Assertions.assertEquals(10, integerGenericArrayWithTypeToken.rep().length);

        integerGenericArrayWithTypeToken.put(1, 20);
        Assertions.assertEquals(20, integerGenericArrayWithTypeToken.get(1));
    }
}

/**
 * 带类型Token的泛型数组
 *
 * @param <T> ：数组类型
 */
class GenericArrayWithTypeToken<T> {
    private final T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

}