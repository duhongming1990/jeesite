package com.thinkgem.jeesite.common.pattern.chain;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019-10-05 13:07
 */
public class SpamHandler implements Handler {
    @Override
    public boolean preHandler(String email) {
        return false;
    }

    @Override
    public void handleRequest(String email) {
        System.out.println("SpamHandler" + email);
    }

    @Override
    public void afterHandler(String email) {

    }
}
