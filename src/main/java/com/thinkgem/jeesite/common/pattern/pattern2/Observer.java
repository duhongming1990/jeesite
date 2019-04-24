package com.thinkgem.jeesite.common.pattern.pattern2;

public interface Observer {

    void update(float temperature, float humidity, float pressure);

    void update(Subject subject);
}
