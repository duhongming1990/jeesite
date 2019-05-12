package com.thinkgem.jeesite.multithread.immutable;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 15:17
 */
public class PrintPersonThread extends Thread{
    private Person person;

    public PrintPersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " prints" + person);
        }
    }
}
