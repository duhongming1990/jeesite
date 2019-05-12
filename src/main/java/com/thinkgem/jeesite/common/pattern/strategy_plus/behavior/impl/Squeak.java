package com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl;


import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.QuackBehavior;

/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:32
 * @Description 橡皮鸭吱吱叫
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        //TODO 橡皮鸭吱吱叫
        System.out.println("Squeak");
    }
}
