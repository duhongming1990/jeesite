package com.thinkgem.jeesite.multithread.single_threaded_execution;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 14:37
 * 不断通过门的人
 */
public class UserThread extends Thread {
    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    @Override
    public void run() {
        System.out.println(myname + "BEGIN");
        while (true) {
            gate.psss(myname, myaddress);
        }
    }
}
