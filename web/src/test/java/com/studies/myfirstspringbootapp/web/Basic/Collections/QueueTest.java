package com.studies.myfirstspringbootapp.web.Basic.Collections;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列测试
 */
public class QueueTest {
    /**
     * 使用LinkedList实现队列成功(先进先出)
     */
    @Test
    public void use_linkedlist_impletements_queue_success() {
        Queue<Integer> queue = new LinkedList<>();

        //在队列尾部插入元素
        for (int i = 0; i < 10; i++) {
            //offer() 是与Queue 相关的方法之一，它在允许的情况下，在队列的尾部插入一个元素，或者返回false 。
            queue.offer(i + 1);
        }

        //从队列头删除元素
        //peek() 和element() 都返回队头元素而不删除它，但是如
        //果队列为空，则element() 抛出NoSuchElementException ，而peek() 返回null
        System.out.print("正在删除元素：");
        while (queue.peek() != null) {
            //poll() 和remove()* 都删除并返回队头元素，但如果队列为空，poll() 返回null ，
            //而remove() 抛出NoSuchElementException 。
            System.out.print(queue.remove() + " ");
        }
    }
}
