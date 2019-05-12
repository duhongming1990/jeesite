package com.thinkgem.jeesite.common.pattern.strategy_plus;

import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl.FlyNoWay;
import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl.FlyRocketPowered;
import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override

    public void display() {
        System.out.println("I'm a model duck");
    }

    public static void main(String[] args) {
        Duck model = new ModelDuck();
        model.performFly();
        //动态设定行为
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
