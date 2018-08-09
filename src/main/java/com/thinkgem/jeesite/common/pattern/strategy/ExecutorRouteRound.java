package com.thinkgem.jeesite.common.pattern.strategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/8/9 15:16
 */
public class ExecutorRouteRound implements  ExecutorRouteStrategy {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public String selectRouteRun(List<String> addressList) {
        Integer count = atomicInteger.getAndIncrement();
        if(count > 1000_0000){
            atomicInteger = new AtomicInteger(0);
        }
        return addressList.get(count%addressList.size());
    }
}