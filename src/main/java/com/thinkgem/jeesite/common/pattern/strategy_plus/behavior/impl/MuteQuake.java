package com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl;

import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.QuackBehavior;

/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:31
 * @Description 什么事都不做，不会叫！
 */

public class MuteQuake implements QuackBehavior {
    @Override
    public void quack() {
        //TODO 什么都不做，不会叫
        System.out.println("<< Silence >>");
    }
}
