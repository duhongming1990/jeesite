package com.thinkgem.jeesite.common.pattern.pattern2;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
