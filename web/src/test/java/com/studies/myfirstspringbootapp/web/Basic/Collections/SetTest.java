package com.studies.myfirstspringbootapp.web.Basic.Collections;

import org.apache.ibatis.annotations.Insert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set测试
 * Set 具有与Collection 相同的接口，因此没有任何额外的功能，不像前面两种不
 * 同类型的List 那样。实际上，Set 就是一个Collection ，只是行为不同。（这是继承
 * 和多态思想的典型应用：表现不同的行为。)
 * --------------------------------------------
 * Set 不保存重复的元素。如果试图将相同对象的多个实例添加到Set 中，那么它会
 * 阻止这种重复行为。Set 最常见的用途是测试归属性，可以很轻松地询问某个对象是否
 * 在一个Set 中。因此，查找通常是Set 最重要的操作，因此通常会选择HashSet 实
 * 现，该实现针对快速查找进行了优化。
 */
public class SetTest {
    /**
     * 初始化HashSet成功
     */
    @Test
    public void initial_hashset_success() {
        Random random = new Random(20);
        Set<Integer> intset = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            intset.add(random.nextInt(30));
        }

        //在0 到29 之间的10000 个随机整数被添加到Set 中，因此可以想象每个值都重复
        //了很多次。但是从结果中可以看到，每一个数只有一个实例出现在结果中。
        System.out.println(intset);
    }

    /**
     * HashSet不排序测试成功
     * 要对结果进行排序，一种方法是使用TreeSet 而不是HashSet
     */
    @Test
    public void hashset_nosort_success() {
        Set<String> colors = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Purple");
        }

        System.out.println(colors);
        Assertions.assertNotEquals("[Yellow, Blue, Red, Orange, Purple]", colors.toString());
    }

    /**
     * 使用TreeSet自动排序成功
     */
    @Test
    public void treeset_autosort_success() {
        Set<String> colors = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Purple");
        }

        System.out.println(colors);
        Assertions.assertEquals("[Blue, Orange, Purple, Red, Yellow]", colors.toString());
    }
}
