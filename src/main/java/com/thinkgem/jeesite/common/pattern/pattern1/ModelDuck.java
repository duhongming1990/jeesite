package com.thinkgem.jeesite.common.pattern.pattern1;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.imple.FlyNoWay;
import com.thinkgem.jeesite.common.pattern.pattern1.behavior.imple.FlyRocketPowered;
import com.thinkgem.jeesite.common.pattern.pattern1.behavior.imple.Quack;

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
