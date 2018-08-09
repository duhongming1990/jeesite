package com.thinkgem.jeesite.common.pattern.strategy;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/26 18:33
 */
public class ExecutorRouteStrategyTest {
    public static void main(String[] args) {

        ExecutorRouteStrategy executorRouteStrategy = ExecutorRouteStrategyEnum.ROUND.getRouteStrategy();

        List<String> addressList = Lists.newArrayList();
        for(int i=1 ; i<=100;i++){
            addressList.add("192.168.1."+i);
        }

        while(true) {
            String address = executorRouteStrategy.selectRouteRun(addressList);
            System.out.println(address);
        }
    }
}