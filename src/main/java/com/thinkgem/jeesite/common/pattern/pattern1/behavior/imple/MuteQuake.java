package com.thinkgem.jeesite.common.pattern.pattern1.behavior.imple;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.QuackBehavior;

public class MuteQuake implements QuackBehavior {
    public void quack() {
        //TODO 什么都不做，不会叫
        System.out.println("<< Silence >>");
    }
}
