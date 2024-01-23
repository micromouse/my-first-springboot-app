package com.studies.myfirstspringbootapp.web.classes;

/**
 * Hello抽象基类
 */
public abstract class HelloBase {
    public HelloBase(String name) {
        System.out.printf("Base constructor, name=%s%n", name);
    }

    public abstract String say();
}
