package com.studies.myfirstspringbootapp.web.Basic.Collections;

import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 迭代器测试
 */
public class IteratorTest {
    /**
     * 在map中迭代成功
     */
    @Test
    public void use_iterable_in_map_success() {
        //System.getenv() 返回一个Map ，entrySet() 产生一个由Map.Entry 的元素
        //构成的Set ，并且这个Set 是一个Iterable ，因此它可以用于for-in 循环。
        Map<String, String> envs = System.getenv();
        for (Map.Entry<String, String> entry : envs.entrySet()) {
            System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * 在迭代器中删除集合成功
     */
    @Test
    public void delete_item_in_iterator_success() {
        List<Integer> list = this.getList();
        System.out.printf("initial list: %s%n", list);
        Assertions.assertEquals(10, (long) list.size());

        //在迭代器中删除偶数项
        this.deleteItems(list);

        System.out.printf("after delete item: %s%n", list);
        Assertions.assertEquals(5, (long) list.size());
    }

    /**
     * 在迭代器中设置项
     */
    @Test
    public void set_item_in_iterator_success() {
        List<Integer> list = this.getList();
        System.out.printf("initial list: %s%n", list);

        //ListIterator可以向后/向前移动元素
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.printf("[value=%d,pindex=%d,nindex=%d]", listIterator.next(), listIterator.previousIndex(), listIterator.nextIndex());
        }
        System.out.println();
        while (listIterator.hasPrevious()) {
            System.out.printf("[value=%d,pindex=%d,nindex=%d]", listIterator.previous(), listIterator.previousIndex(), listIterator.nextIndex());
        }

        //从第三个元素开始更新元素值
        this.setItems(list.listIterator(3));
        System.out.printf("%nafter set item list: %s%n", list);
    }

    /**
     * 使用ListIterator在迭代中更新项
     *
     * @param listIterator : ListIterator
     */
    private void setItems(ListIterator<Integer> listIterator) {
        while (listIterator.hasNext()) {
            listIterator.set(listIterator.next() + 1);
        }
    }


    /**
     * 删除可迭代器集合中的项
     *
     * @param iterable ：可迭代器
     */
    private void deleteItems(Iterable<Integer> iterable) {
        Iterator<Integer> iterator = iterable.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
    }

    private List<Integer> getList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        return list;
    }
}
