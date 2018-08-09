package com.thinkgem.jeesite.common.pattern.strategy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/25 10:39
 */
public class ExecutorRouteLFU implements ExecutorRouteStrategy{
    private static ConcurrentHashMap<String,Integer> lfuItemMap = new ConcurrentHashMap<>();
    @Override
    public String selectRouteRun(List<String> addressList) {
        for(String address:addressList){
            if(!lfuItemMap.containsKey(address)){
                lfuItemMap.put(address,0);
            }
        }
        List<Map.Entry<String,Integer>> itemList = new ArrayList<>(lfuItemMap.entrySet());
        Collections.sort(itemList, Comparator.comparing(Map.Entry::getValue));
        Map.Entry<String, Integer> itemMap = itemList.get(0);
        itemMap.setValue(itemMap.getValue()+1);
        return itemMap.getKey();
    }
}