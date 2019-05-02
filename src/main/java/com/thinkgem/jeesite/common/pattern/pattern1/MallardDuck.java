package com.thinkgem.jeesite.common.pattern.pattern1;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl.FlyWithWings;
import com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl.Quack;
/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:33
 * @Description 绿头鸭
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        super();
        super.setFlyBehavior(new FlyWithWings());
        super.setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("外观是绿头");
    }

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performAll();
    }
}
