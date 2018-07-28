package com.thinkgem.jeesite.common.pattern.strategy;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/25 9:55
 * 总是执行第一个
 */
public class ExecutorRouteFirst implements ExecutorRouteStrategy {

    @Override
    public String selectRouteRun(List<String> addressList) {
        if(CollectionUtils.isNotEmpty(addressList)){
            return addressList.get(0);
        }else{
            return StringUtils.EMPTY;
        }
    }

}