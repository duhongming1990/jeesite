package com.thinkgem.jeesite.common.pattern.pattern1;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl.FlyWithWings;
import com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl.Quack;

/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:33
 * @Description 红头鸭
 */
public class RedHeadDuck extends Duck {

    public RedHeadDuck(){
        super();
        super.setQuackBehavior(new Quack());
        super.setFlyBehavior(new FlyWithWings());
    }

    @Override
    public void display() {
        System.out.println("外观是红头");
    }

    public static void main(String[] args) {
        Duck redHeadDuck = new RedHeadDuck();
        redHeadDuck.performAll();
    }
}
