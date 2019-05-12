package com.thinkgem.jeesite.multithread.immutable;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 15:20
 */
public class Main {
    public static void main(String[] args) {
        Person alice = new Person("Alice", "Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();

    }
}
