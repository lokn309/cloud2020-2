package com.test;

import sun.java2d.loops.FontInfo;

import java.util.HashMap;
import java.util.UUID;

/**
 * @description:
 * @author: lokn
 * @date: 2020/11/28 16:49
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        final HashMap map = new HashMap<String, String>(2);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        thread.start();
        thread.join();
    }

}
