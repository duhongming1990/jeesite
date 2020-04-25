package com.thinkgem.jeesite.common.pattern.chain;

public interface Handler {
    boolean preHandler(String email);
    void handleRequest(String email);
    void afterHandler(String email);
}
