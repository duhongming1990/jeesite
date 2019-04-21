package com.thinkgem.jeesite.common.pattern.pattern1.behavior.imple;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket！");
    }
}
