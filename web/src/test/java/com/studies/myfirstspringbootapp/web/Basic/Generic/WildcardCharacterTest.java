package com.studies.myfirstspringbootapp.web.Basic.Generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型通配符测试
 */
public class WildcardCharacterTest {
    /**
     * 集合中不能添加任何类型
     * 使用 ? extends T（协变）表示这个泛型容器可以持有类型为 T 或 T 的任何子类的对象。
     * 这样的容器主要用于读取 T 类型的数据，因为你可以保证容器中的每个对象至少是 T 类型的实例。
     * 但是，你不能向这样的容器中添加 T 类型的对象（除了 null），因为实际的容器类型可能是 T 的任何子类型，
     * 而添加一个 T 类型的对象到一个特定 T 的子类型的容器中是不安全的。
     */
    @Test
    public void cannot_add_anytype_in_collection_success() {
        //? extends T 用于安全地读取 T 类型的数据，因为你知道容器中的任何对象至少是 T 的实例。
        List<? extends Fruit> list = new ArrayList<>();

        /*
         * list.add(new Fruit());
         * list.add(new Object());
         * list.add(new Apple());
         */

        list.add(null);
        Fruit fruit = list.get(0);
        Assertions.assertNull(fruit);
    }

    /**
     * 初始化使用? extends T（协变）集合成功
     */
    @Test
    public void initial_extends_wildcards_collection_success() {
        Fruit fruit = new Fruit();
        List<? extends Fruit> list = Arrays.asList(fruit, new Apple());
        Assertions.assertTrue(list.get(1) instanceof Apple);
        Assertions.assertTrue(list.contains(fruit));
    }

    /**
     * 集合中可以添加任意子类型
     * 使用 ? super T（逆变）表示这个泛型容器可以被赋值为持有 T 类型或任何 T 的父类型的对象的容器。
     * 这样的容器可以安全地向其写入 T 类型及其子类型的对象，因为无论容器的具体类型是什么，
     * T 类型的对象和其子类型的对象都可以被赋值给 T 类型或其任何父类型的引用。
     */
    @Test
    public void can_add_child_type_in_collection_success() {
        //? super T 用于安全地写入 T 类型的数据，因为你知道容器可以持有 T 类型或任何 T 的父类型的对象。
        List<? super Fruit> list = new ArrayList<>();
        list.add(new Fruit());
        list.add(new Apple());
        Assertions.assertEquals(2, list.size());

        Object object = list.get(0);
        Fruit fruit = (Fruit) list.get(0);
        Assertions.assertEquals(object, fruit);
        Assertions.assertNotNull(list.get(0));
    }
}

class Fruit {
}

class Apple extends Fruit {

}

class FujiApple extends Apple {
}

class Orange extends Fruit {

}