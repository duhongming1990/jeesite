package com.thinkgem.jeesite.multithread.guarded_suspension;


import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 15:47
 * 发送请求的类
 */
public class ClientThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(long seed, RequestQueue requestQueue, String name) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + " requests" + request);
            requestQueue.putRequest(request);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
