package com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl;


import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.FlyBehavior;

/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:28
 * @Description 什么事都不做，不会飞！
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        //TODO 什么都不做，不会飞
        System.out.println("I can't fly");
    }
}
