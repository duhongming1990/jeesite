package com.thinkgem.jeesite.common.pattern.strategy_plus;


import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl.FlyNoWay;
import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.impl.Squeak;

/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:34
 * @Description
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        super();
        super.setFlyBehavior(new FlyNoWay());
        super.setQuackBehavior(new Squeak());
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }

    public static void main(String[] args) {
        Duck rubberDuck = new RubberDuck();
        rubberDuck.performAll();
    }

}
