package com.thinkgem.jeesite.multithread.single_threaded_execution;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 14:41
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRL+C to exit.");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canad").start();
    }
}
