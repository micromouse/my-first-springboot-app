package com.studies.myfirstspringbootapp.web.Basic;

import org.junit.jupiter.api.Test;

/**
 * 显示的静态初始化测试
 */
public class ExplictStaticInitializeTest {
    static Cups cups1 = new Cups();

    /**
     * 测试显示的静态初始化
     */
    @Test
    public void test() {
        Cups.cup1.f(99);
        /*
          输出顺序
          Cup(1)
          Cup(2)
          Cups()  -- 注释掉这一行代码[static Cups cups1 = new Cups();],将不会输出Cups()
          print(99)
         */
    }
}

class Cup {
    Cup(int marker) {
        System.out.printf("Cup(%s)%n", marker);
    }

    void f(int marker) {
        System.out.printf("print(%s)%n", marker);
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    /*
      显示的静态初始化，第一次实例化或第一次调用静态成员时执行
     */
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}
