package com.thinkgem.jeesite.multithread.guarded_suspension;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 15:44
 * 依次存放请求的类
 */
public class RequestQueue {
    //    private final Queue<Request> queue = new LinkedList<>();
    private final BlockingDeque<Request> queue = new LinkedBlockingDeque<>();

//    public synchronized Request getRequest() {
//        while (queue.peek() == null) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return queue.remove();
//    }

    public Request getRequest() {
        Request request = null;
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return request;
    }

//    public synchronized void putRequest(Request request) {
//        queue.offer(request);
//        notifyAll();
//    }

    public void putRequest(Request request) {
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
