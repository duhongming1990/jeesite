package com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl;


import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.FlyBehavior;

/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:29
 * @Description 用翅膀飞
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        //TODO 实现鸭子飞行
        System.out.println("I'm flying!!");
    }
}
