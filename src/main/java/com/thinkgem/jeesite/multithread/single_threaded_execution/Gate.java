package com.thinkgem.jeesite.multithread.single_threaded_execution;

import sun.awt.Mutex;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 14:30
 * 门：SharedResource(共享资源)
 */
public class Gate {

    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    private final Mutex mutex = new Mutex();

    /**
     * 通过门，counter+1，并检查状态
     * @param name
     * @param address
     */
//    public synchronized void psss(String name, String address) {
//        this.counter++;
//        this.name = name;
//        this.address = address;
//        check();
//    }

    public void psss(String name, String address) {
        mutex.lock();
        try {
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        }finally {
            mutex.unlock();
        }
    }

//    public synchronized String toString() {
//        return "No." + counter+":"+name +"," + address;
//    }

    public synchronized String toString() {
        mutex.lock();
        String s;
        try{
            s = "No." + counter+":"+name +"," + address;
        }finally {
            mutex.unlock();
        }
        return s;
    }

    /**
     * 姓名和出生地不同，那记录数据是异常的
     */
    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ****** " + toString());
        }
    }
}
