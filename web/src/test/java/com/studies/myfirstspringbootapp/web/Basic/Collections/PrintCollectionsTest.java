package com.studies.myfirstspringbootapp.web.Basic.Collections;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 打印集合测试
 */
public class PrintCollectionsTest {
    /**
     * 打印
     */
    @Test
    public void print() {
        /*
         * ArrayList 和 LinkedList 都会按照元素插入的顺序来维护顺序。
         * 在你的 fill 方法中，你向这些集合添加了 "rat"、"cat"、"dog" 和 "dog"，
         * 因此两者的输出都是相同的：[rat, cat, dog, dog]。
         * ArrayList<>: [rat, cat, dog, dog]
         * LinkedList<>: [rat, cat, dog, dog]
         *
         * HashSet 不允许重复元素。因此，重复的 "dog" 被移除，输出为：[rat, cat, dog]。
         * HashSet<>: [rat, cat, dog]
         *
         * TreeSet 根据元素的自然顺序或一个比较器进行排序。在你的情况下，元素按照词典顺序排序，输出为：[cat, dog, rat]。
         * TreeSet<>: [cat, dog, rat]
         *
         * LinkedHashSet<>: [rat, cat, dog]
         *
         * HashMap 和 LinkedHashMap 都不允许重复的键。当尝试使用相同的键 "dog" 放入不同的值时，
         * 最后一个值（"Spot"）将覆盖先前的值（"Bosco"）。因此，HashMap 和 LinkedHashMap 的输出都是：{rat=Fuzzy, cat=Rags, dog=Spot}。
         * HashMap<>: {rat=Fuzzy, cat=Rags, dog=Spot}
         *
         * TreeMap 根据元素的自然顺序或一个比较器对条目进行排序。在你的情况下，条目按照键的词典顺序排序，
         * 输出为：{cat=Rags, dog=Spot, rat=Fuzzy}。
         * TreeMap<>: {cat=Rags, dog=Spot, rat=Fuzzy}
         * LinkedHashMap<>: {rat=Fuzzy, cat=Rags, dog=Spot}
         */
        System.out.printf("ArrayList<>: %s%n", fill(new ArrayList<>()));
        System.out.printf("LinkedList<>: %s%n", fill(new LinkedList<>()));
        System.out.printf("HashSet<>: %s%n", fill(new HashSet<>()));
        System.out.printf("TreeSet<>: %s%n", fill(new TreeSet<>()));
        System.out.printf("LinkedHashSet<>: %s%n", fill(new LinkedHashSet<>()));
        System.out.printf("HashMap<>: %s%n", fill(new HashMap<>()));
        System.out.printf("TreeMap<>: %s%n", fill(new TreeMap<>()));
        System.out.printf("LinkedHashMap<>: %s%n", fill(new LinkedHashMap<>()));
    }

    private Collection<String> fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    private Map<String, String> fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

}
