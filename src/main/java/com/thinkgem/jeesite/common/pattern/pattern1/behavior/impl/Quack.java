package com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.QuackBehavior;
/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:31
 * @Description 鸭子呱呱叫
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
