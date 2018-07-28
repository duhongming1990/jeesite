package com.thinkgem.jeesite.common.pattern.strategy;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/25 10:36
 * 总是执行最后一个
 */
public class ExecutorRouteLast implements ExecutorRouteStrategy {
    @Override
    public String selectRouteRun(List<String> addressList) {
        if(CollectionUtils.isNotEmpty(addressList)){
            return addressList.get(addressList.size()-1);
        }
        return StringUtils.EMPTY;
    }
}