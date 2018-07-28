package com.thinkgem.jeesite.common.pattern.strategy;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Random;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/26 23:52
 */
public class ExecutorRouteRandom implements ExecutorRouteStrategy {
    private Random random = new Random();
    @Override
    public String selectRouteRun(List<String> addressList) {
        if(CollectionUtils.isNotEmpty(addressList)){
            addressList.get(random.nextInt(addressList.size()));
        }
        return null;
    }
}