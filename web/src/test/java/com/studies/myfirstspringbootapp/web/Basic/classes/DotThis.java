package com.studies.myfirstspringbootapp.web.Basic.classes;

/**
 * 使用this
 */
public class DotThis {
    public String f() {
        return "DotThis.print()";
    }

    public Inner inner() {
        return new Inner();
    }

    public class Inner {
        public DotThis outer() {
            //使用.this指向对父类的引用
            return DotThis.this;
        }
    }
}
