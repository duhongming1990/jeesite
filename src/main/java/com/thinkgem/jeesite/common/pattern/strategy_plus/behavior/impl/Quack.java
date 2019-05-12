package com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl;

import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.QuackBehavior;

/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:31
 * @Description 鸭子呱呱叫
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        //TODO 实现鸭子呱呱叫
        System.out.println("Quack");
    }
}
