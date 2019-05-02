package com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.FlyBehavior;
/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:28
 * @Description 什么事都不做，不会飞！
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
