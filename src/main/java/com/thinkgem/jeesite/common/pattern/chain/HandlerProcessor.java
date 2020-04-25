package com.thinkgem.jeesite.common.pattern.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019-10-05 13:10
 */
public class HandlerProcessor{
    private List<Handler> handlers = new ArrayList<>();

    public HandlerProcessor addHandler(Handler handler){
        handlers.add(handler);
        return this;
    }

    public void handleRequest(String email) {
        for (Handler handler : handlers) {
            if(handler.preHandler(email)) {
                handler.handleRequest(email);
            }
            handler.afterHandler(email);
        }
    }
}
