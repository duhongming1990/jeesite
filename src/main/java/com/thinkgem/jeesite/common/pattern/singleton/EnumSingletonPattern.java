package com.thinkgem.jeesite.common.pattern.singleton;

/**
 * @author duhongming
 * @version 1.0
 * @description 枚举单例模式、终极解决方案，请使用！
 * @date 2019-09-13 09:42
 */
public class EnumSingletonPattern {

    private EnumSingletonPattern(){}

    public static EnumSingletonPattern getInstance() {
        return Singleton.INSTANCE.getIntance();
    }

    private enum Singleton{

        INSTANCE;

        private EnumSingletonPattern instance;

        //JVM保证这个只执行一次
        Singleton(){
            instance = new EnumSingletonPattern();
        }

        public EnumSingletonPattern getIntance(){
            return instance;
        }
    }
}