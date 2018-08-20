package com.thinkgem.jeesite.common.pattern.strategy;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/7/26 18:18
 */
public enum ExecutorRouteStrategyEnum {

    FIRST("第一个",new ExecutorRouteFirst()),
    LAST("最后一个",new ExecutorRouteLast()),
    LFU("最不经常使用",new ExecutorRouteLFU()),
    LRU("最近最久未使用",new ExecutorRouteLRU()),
    RANDOM("随机",new ExecutorRouteRandom()),
    ROUND("轮询",new ExecutorRouteRound()),
    BUSYOVER("繁忙转移",new ExecutorRouteBusyover()),
    FAILOVER("故障转移",new ExecutorRouteFailover());

    private String title;
    private ExecutorRouteStrategy routeStrategy;
    ExecutorRouteStrategyEnum(String title,ExecutorRouteStrategy routeStrategy){
        this.title = title;
        this.routeStrategy = routeStrategy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ExecutorRouteStrategy getRouteStrategy() {
        return routeStrategy;
    }

    public void setRouteStrategy(ExecutorRouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }
}