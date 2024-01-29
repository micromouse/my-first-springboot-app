package com.studies.myfirstspringbootapp.web.Basic.classes;

import org.junit.jupiter.api.Test;

/**
 * 内部类继承测试
 */
public class InnerClassInheritTest {
    /**
     * 派生内部类不影响基类内部类
     */
    @Test
    public void extends_innerclass_not_effect_base_innerclass_success() {
        new BigEgg();
        /*
         * 派生类BigEgg重写了基类Egg的内部类Yolk，但是没有覆盖基类内部类Yolk
         * 因此没有输出BigEgg.Yolk()
         * 输出顺序如下：
         * new Egg()
         * Egg.Yolk()
         */
    }

    /**
     * 派生内部类继承基类内部类
     */
    @Test
    public void extends_innerclass_inherit_base_innerclass_success() {
        Egg2 egg2 = new BigEgg2();
        egg2.invokeYolkf();

        /*
         * 输出顺序如下：
         * Egg2.Yolk() ：实例化派生类BigEgg2时先初始化基类Egg2中的成员变量Yolk
         * new Egg2() ：实例化派生类BigEgg2时先调用基类Egg2构造函数
         * Egg2.Yolk() ：派生类BigEgg构造函数实例化Yolk先调用基类Yolk构造函数
         * BigEgg2.Yolk()
         * BigEgg2.Yolk.print() ：基类Egg2中的内部类Yolk的print方法被派生类覆盖了
         */
    }
}

class Egg {
    private final Yolk yolk;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    Egg() {
        System.out.println("new Egg()");
        yolk = new Yolk();
    }
}

class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }
}

class Egg2 {
    private Yolk yolk = new Yolk();

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg2.Yolk()");
        }

        public void print() {
            System.out.println("Egg2.Yolk.print()");
        }
    }

    Egg2() {
        System.out.println("new Egg2()");
    }

    public void insertYolk(Yolk yolk) {
        this.yolk = yolk;
    }

    public void invokeYolkf() {
        yolk.print();
    }
}

class BigEgg2 extends Egg2 {
    /**
     * 继承基类Egg2中的内部类Yolk
     */
    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("BigEgg2.Yolk()");
        }

        @Override
        public void print() {
            System.out.println("BigEgg2.Yolk.print()");
        }
    }

    public BigEgg2() {
        //调用基类insertYolk将派生类BigEgg2中的Yolk实现向上转型为Egg2中的Yolk引用
        super.insertYolk(new Yolk());
    }

}