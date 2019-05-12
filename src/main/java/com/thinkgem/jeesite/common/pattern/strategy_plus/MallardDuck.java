package com.thinkgem.jeesite.common.pattern.strategy_plus;

import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl.FlyWithWings;
import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl.Quack;

public class MallardDuck extends Duck{

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void swim() {

    }

    public void display() {
        System.out.println("外观是绿头");
    }

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();
    }
}
