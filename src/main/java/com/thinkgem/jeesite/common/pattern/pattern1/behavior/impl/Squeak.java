package com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.QuackBehavior;
/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:32
 * @Description 橡皮鸭吱吱叫
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
