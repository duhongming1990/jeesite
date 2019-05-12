package com.thinkgem.jeesite.multithread.guarded_suspension;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 15:53
 * 接收请求的类
 */
public class ServerThread extends Thread {

    private final Random random;
    private final RequestQueue requestQueue;

    public ServerThread(long seed, RequestQueue requestQueue, String name) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles" + request);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
