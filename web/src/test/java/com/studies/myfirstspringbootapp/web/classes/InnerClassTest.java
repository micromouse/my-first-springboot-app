package com.studies.myfirstspringbootapp.web.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 内部类测试
 */
public class InnerClassTest {
    final boolean useMethodInner = true;

    /**
     * 从内部类使用父类.this获得对外部类引用
     * 然后调用外部类方法
     */
    @Test
    public void get_outerclass_reference_from_innerclass_use_dotthis_success() {
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = dotThis.inner();
        Assertions.assertEquals(dotThis, inner.outer());
        Assertions.assertEquals("DotThis.print()", inner.outer().f());
    }

    /**
     * 使用外部类实例.new 内部类创建内部类实例成功
     */
    @Test
    public void create_innerclass_instance_use_dotnew_success() {
        Collectors.joining(" ");
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = dotThis.new Inner();
        Assertions.assertEquals("DotThis.print()", inner.outer().f());

        /*
         * 不能按想象的方式使用下列方法实例化一个内部类
         * DotThis.Inner iner = new DotThis.Inner();
         * 编译器会报以下异常
         * 'com.studies.myfirstspringbootapp.web.classes.DotThis' is not an enclosing class
         *
         * 在拥有外部类对象之前是不可能创建内部类对象的。这是因为内部类对象会暗暗
         * 地连接到建它的外部类对象上。但是，如果你创建的是嵌套类（静态内部类），
         * 那么它就不需要对外部类对象的引用。
         */
    }

    /**
     * 在方法内创建内部类成功
     */
    @Test
    public void create_innerclass_in_method_success() {
        //有条件创建内部类，作用域在if块内
        if (useMethodInner) {
            class MethodInner {
                public String value() {
                    return "value";
                }
            }
            Assertions.assertEquals("value", new MethodInner().value());
        }

        /*
         * 这里就不能使用MethodInner了
         * MethodInner methodInner = new MethodInner();
         * Cannot resolve symbol 'MethodInner'
         */

        //方法内使用内部类实现接口，向上转型为接口实例返回
        Assertions.assertEquals("Hello.say", getHello().say());
    }

    /**
     * 使用anonymouse[əˈnɑːnɪməs]匿名类实现接口成功
     */
    @Test
    public void use_anonymous_class_implements_interface_success() {
        //使用Lamda匿名类实现接口(只有一个接口方法，也叫匿名函数)
        IHello lamdaHello = () -> "lamdaHello.say";
        Assertions.assertEquals("lamdaHello.say", lamdaHello.say());

        //使用普通匿名类实现接口
        IHello hello = new IHello() {
            @Override
            public String say() {
                return "anonymouse.ihello.say";
            }
        };
        Assertions.assertEquals("anonymouse.ihello.say", hello.say());
    }

    /**
     * 使用匿名类实现带参数构造函数类
     * 控制台输出：
     * Base constructor, name=myname
     * Inside instance initializer, name=myname
     */
    @Test
    public void use_anonymouse_class_extends_hasargs_constructor_class_success() {
        String name = "myname";
        HelloBase helloBase = this.getHelloBase(name);
        Assertions.assertEquals("say: " + name, helloBase.say());
    }

    /**
     * 使用局部内部类获得IHello实现
     *
     * @return ：Ihello实现
     */
    private IHello getHello() {
        final class Hello implements IHello {

            @Override
            public String say() {
                return "Hello.say";
            }
        }

        return new Hello();
    }

    /**
     * 如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，那么编译
     * 器会要求其参数引用是final 的（也就是说，它在初始化后不会改变，所以可以被当作
     * final），
     * 这里省略掉final也没问题，但是通常最好加上final 作为一种暗示。
     *
     * @param content : 内容(不会被改变)
     * @return ：IHello实例
     */
    private IHello getHello(final String content) {
        return new IHello() {
            private final String label = content;

            @Override
            public String say() {
                return label;
            }
        };
    }

    /**
     * 使用匿名类获得带参数构造器类实例
     * 匿名内部类与正规的继承相比有些受限，因为匿名内部类既可以扩展类，也可以实
     * 现接口，但是不能两者兼备。而且如果是实现接口，也只能实现一个接口。
     *
     * @param name : 名称
     * @return ：HelloBase实例
     */
    private HelloBase getHelloBase(final String name) {
        return new HelloBase(name) {
            {
                System.out.printf("Inside instance initializer, name=%s%n", name);
            }

            private final String label = name;

            @Override
            public String say() {
                return "say: " + label;
            }
        };
    }

}
