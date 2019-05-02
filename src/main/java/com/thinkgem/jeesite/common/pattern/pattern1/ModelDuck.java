package com.thinkgem.jeesite.common.pattern.pattern1;

import com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl.FlyNoWay;
import com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl.FlyRocketPowered;
import com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl.MuteQuake;
import com.thinkgem.jeesite.common.pattern.pattern1.behavior.impl.Quack;
/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:33
 * @Description 模型鸭
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        super();
        super.setFlyBehavior(new FlyNoWay());
        super.setQuackBehavior(new MuteQuake());
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }

    public static void main(String[] args) {
        Duck model = new ModelDuck();
        model.performAll();
        //动态设定行为
        model.setFlyBehavior(new FlyRocketPowered());
        model.performAll();
    }
}
