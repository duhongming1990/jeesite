package com.thinkgem.jeesite.common.pattern.pattern1;

public class RubberDuck extends Duck {
    public void quack() {

    }

    public void swim() {

    }

    public void display() {
        System.out.println("外观是橡皮鸭");
    }

    /**
     * 这货不会飞啊
     */
    public void fly() {
        //覆盖，变成什么事都不做
    }
}
