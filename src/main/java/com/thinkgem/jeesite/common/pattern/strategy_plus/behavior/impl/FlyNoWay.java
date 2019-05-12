package com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl;

import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        //TODO 什么都不做，不会飞
        System.out.println("I can't fly");
    }
}
