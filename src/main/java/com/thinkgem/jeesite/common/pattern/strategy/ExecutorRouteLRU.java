package com.thinkgem.jeesite.common.pattern.strategy;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/26 22:08
 */
public class ExecutorRouteLRU implements ExecutorRouteStrategy {
    private static LinkedHashMap<String,String> lruItemMap = new LinkedHashMap<>(16,0.75f,true);
    @Override
    public String selectRouteRun(List<String> addressList) {

        for(String address:addressList){
            if(!lruItemMap.containsValue(address)){
               lruItemMap.put(address,address);
            }
        }

        String eldestKey = lruItemMap.entrySet().iterator().next().getKey();
        String eldestValue = lruItemMap.get(eldestKey);
        return eldestValue;
    }
}