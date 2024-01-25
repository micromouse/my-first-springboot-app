package com.studies.myfirstspringbootapp.web.Basic.Collections;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 反向迭代器测试
 */
public class ReversiableIteratorTest {
    /**
     * 反向迭代ArrayList成功
     */
    @Test
    public void reversed_arraylist_iterable_success() {
        List<String> list = Arrays.asList("to be or not to be".split(" "));
        ReversiableArrayList<String> reverseList = new ReversiableArrayList<>(list);

        //普通迭代
        System.out.print("普通迭代：");
        for (String s : reverseList) {
            System.out.printf("%s ", s);
        }

        //反向迭代
        System.out.printf("%n反向迭代：");
        for (String s : reverseList.reversed()) {
            System.out.printf("%s ", s);
        }
    }
}

/**
 * 可反向ArrayList<T>
 *
 * @param <T> : 集合元素类型
 */
class ReversiableArrayList<T> extends ArrayList<T> {
    ReversiableArrayList(Collection<T> collection) {
        super(collection);
    }

    /**
     * 获得反向可迭代器
     *
     * @return ：反向可迭代器
     */
    public Iterable<T> reversed() {
        return () -> new Iterator<T>() {
            int current = size() - 1;

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                return get(current--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("未实现删除操作");
            }
        };
    }
}
