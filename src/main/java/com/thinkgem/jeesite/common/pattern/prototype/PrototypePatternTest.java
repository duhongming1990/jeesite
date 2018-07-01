package com.thinkgem.jeesite.common.pattern.prototype;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/6/19 10:04
 * 表明浅复制只会复制对象本身，里面封装的对象不会复制。
 */
public class PrototypePatternTest {
    public static void main(String[] args) throws CloneNotSupportedException{

        PrototypePattern prototype = new PrototypePattern();

        prototype.setString("PrototypeSerializableObject");
        prototype.setObj(new PrototypeSerializableObject("duhongming", 28, 72.2));

        System.out.println("prototype原型：" + prototype);
        System.out.println("prototype浅复制：" + prototype.clone());
        System.out.println("prototype深复制：" + prototype.deepClone());
        System.out.println("prototype文件复制：" + prototype.fileClone());
        System.out.println("prototype管道复制：" + prototype.pipeClone());

        System.out.println("setObj原型：" + prototype.getObj());
        System.out.println("setObj浅复制：" + prototype.clone().getObj());
        System.out.println("setObj深复制：" + prototype.deepClone().getObj());
        System.out.println("setObj文件复制：" + prototype.fileClone().getObj());
        System.out.println("setObj管道复制：" + prototype.pipeClone().getObj());
    }
}
