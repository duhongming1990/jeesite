package com.thinkgem.jeesite.multithread.guarded_suspension;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-05-12 15:43
 * 表示一个请求的类
 */
public class Request {
    private final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
