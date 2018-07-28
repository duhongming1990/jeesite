package com.thinkgem.jeesite.common.pattern.strategy;

import java.util.List;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/25 9:52
 */
public interface ExecutorRouteStrategy {
    String selectRouteRun(List<String> addressList);
}