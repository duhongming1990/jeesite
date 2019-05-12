package com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl;

import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket！");
    }
}
