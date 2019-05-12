package com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl;

import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.QuackBehavior;

public class MuteQuake implements QuackBehavior {
    public void quack() {
        //TODO 什么都不做，不会叫
        System.out.println("<< Silence >>");
    }
}
