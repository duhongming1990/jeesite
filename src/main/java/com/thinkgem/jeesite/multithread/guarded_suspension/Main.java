package com.thinkgem.jeesite.multithread.guarded_suspension;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 15:56
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(3141592L,requestQueue, "Alice").start();
        new ServerThread(6535897L, requestQueue, "Bobby").start();

    }
}
