package com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl;


import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.FlyBehavior;

/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:28
 * @Description 火箭动力飞
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket！");
    }
}
