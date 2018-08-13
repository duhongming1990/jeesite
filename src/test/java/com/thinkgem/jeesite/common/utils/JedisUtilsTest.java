package com.thinkgem.jeesite.common.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context-test.xml","classpath:spring-context-jedis-test.xml"})
public class JedisUtilsTest {
    private static int count = 0;

    @Test
    public void testBlockDistributionLock() throws InterruptedException {
        int availProcessors = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newFixedThreadPool(availProcessors);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(()->{
                JedisUtils.tryGetNonBlockLock("lockKey","0000-0000");
                System.out.println("Thread.currentThread().getName()开始 = " + Thread.currentThread().getName());
                count++;
                System.out.println("Thread.currentThread().getName()结束 = " + Thread.currentThread().getName());
                JedisUtils.releaseLock("lockKey","0000-0000");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count = " + count);
    }



}