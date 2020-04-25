package com.thinkgem.jeesite.common.pattern.chain;

import static org.junit.Assert.*;

public class HandlerProcessorTest {
    public static void main(String[] args) {
        HandlerProcessor handlerProcessor = new HandlerProcessor();
        handlerProcessor.addHandler(new ComplainHandler())
                .addHandler(new FanHandler())
                .addHandler(new NewLocHandler())
                .addHandler(new SpamHandler()).handleRequest(" email test");

    }

}