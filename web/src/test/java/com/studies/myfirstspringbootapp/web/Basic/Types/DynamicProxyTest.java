package com.studies.myfirstspringbootapp.web.Basic.Types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Optional;

/**
 * 动态代理测试
 */
public class DynamicProxyTest {
    /**
     * 通过动态代理处理器调用实际对象方法成功
     */
    @Test
    public void invoke_method_by_dynamicproxy_success() {
        SimpleExample simpleExample = new SimpleExample();
        Assertions.assertEquals("admin", simpleExample.getName(null));
        Assertions.assertEquals(20, simpleExample.getAge(null));

        Object proxy = Proxy.newProxyInstance(
                DynamicProxyTest.class.getClassLoader(),
                new Class[]{IExample1.class, IExample2.class},
                new DynamicProxyHandler(simpleExample));
        Assertions.assertEquals("proxy", ((IExample1) proxy).getName("proxy"));
        Assertions.assertEquals(100, ((IExample2) proxy).getAge(100));
    }
}

/**
 * 动态代理处理器
 */
class DynamicProxyHandler implements InvocationHandler {
    private final Object proxied;

    /**
     * 初始化动态代理处理器
     *
     * @param proxied ：执行方法的实际对象
     */
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    /**
     * 动态调用方法
     *
     * @param proxy  ：调用方法的实例
     * @param method ：方法
     * @param args   ：参数
     * @return ：结果
     * @throws Throwable ：异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String argsStr = Optional.ofNullable(args)
                .map(Arrays::toString)
                .orElse("null");
        System.out.printf("**** %nproxy: %s, %nmethod:%s, %nargs: %s", proxy.getClass(), method, argsStr);

        //在proxied上执行method，返回结果
        return method.invoke(proxied, args);
    }
}

interface IExample1 {
    String getName(String name);
}

interface IExample2 {
    int getAge(Integer age);
}

class SimpleExample implements IExample1, IExample2 {
    private final String name;
    private final int age;

    public SimpleExample() {
        this.name = "admin";
        this.age = 20;
    }

    @Override
    public String getName(String name) {
        return Optional.ofNullable(name).orElse(this.name);
    }

    @Override
    public int getAge(Integer age) {
        return Optional.ofNullable(age).orElse(this.age);
    }
}