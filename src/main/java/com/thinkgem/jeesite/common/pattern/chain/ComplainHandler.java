package com.thinkgem.jeesite.common.pattern.chain;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019-10-05 13:09
 */
public class ComplainHandler implements Handler {
    @Override
    public boolean preHandler(String email) {
        return true;
    }

    @Override
    public void handleRequest(String email) {
        System.out.println("ComplainHandler" + email);
    }

    @Override
    public void afterHandler(String email) {

    }
}
