package com.studies.myfirstspringbootapp.web.Basic.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 堆栈测试(后进先出)
 */
public class DequeTest {
    /**
     * 使用Arraydeque压栈出栈成功
     */
    @Test
    public void push_and_pop_arraydeque_success() {
        Deque<String> deque = new ArrayDeque<>();

        //压栈到ArrayDeque
        for (String s : "My dog has fleas".split(" ")) {
            deque.push(s);
        }

        StringBuilder pops = new StringBuilder();
        while (!deque.isEmpty()) {
            pops.append(deque.pop()).append(" ");
        }
        Assertions.assertEquals("fleas has dog My", pops.toString().trim());
    }

    /**
     * 使用Stack压栈出栈成功
     * 尽管已经有了java.util.Stack ，但是ArrayDeque 可以产生更好的Stack ，因此更可取。
     */
    @Test
    public void push_and_pop_stack_success() {
        Stack<String> stack = new Stack<>();

        //压栈到Stack
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }

        StringBuilder pops = new StringBuilder();
        while (!stack.isEmpty()) {
            pops.append(stack.pop()).append(" ");
        }
        Assertions.assertEquals("fleas has dog My", pops.toString().trim());
    }

}
