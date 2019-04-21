package com.thinkgem.jeesite.common.pattern.pattern1.behavior.imple;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        //TODO 什么都不做，不会飞
        System.out.println("I can't fly");
    }
}
