package com.thinkgem.jeesite.common.pattern.chain;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019-10-05 13:08
 */
public class FanHandler implements Handler {
    @Override
    public boolean preHandler(String email) {
        System.out.println("preHandler");
        return true;
    }

    @Override
    public void handleRequest(String email) {
        System.out.println("FanHandler" + email);
    }

    @Override
    public void afterHandler(String email) {
        System.out.println("afterHandler");
    }
}
