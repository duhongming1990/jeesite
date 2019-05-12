package com.thinkgem.jeesite.common.pattern.strategy_plus;

import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.FlyBehavior;
import com.thinkgem.jeesite.common.pattern.strategy_plus.behavior.QuackBehavior;
import lombok.Getter;
import lombok.Setter;
/**
 * @Author duhongming
 * @Email duhm@mydubang.com
 * @Date 2019/5/2 20:42
 * @Description 
 */
@Getter
@Setter
public abstract class Duck {

    /**
     * default：内部类和本包访问，子类和外部包不能访问
     */
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    /**
     * 外观
     */
    public abstract void display();

    /**
     * 游泳
     */
    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }

    /**
     * delegate FlyBehavior implements
     */
    public void performFly(){
        flyBehavior.fly();
    }

    /**
     * delegate QuackBehavior implements
     */
    public void performQuack(){
        quackBehavior.quack();
    }
    
    public void performAll(){
        display();
        swim();
        performQuack();
        performFly();
    }
}
