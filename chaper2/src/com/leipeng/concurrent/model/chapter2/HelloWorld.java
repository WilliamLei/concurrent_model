package com.leipeng.concurrent.model.chapter2;

/**
 * Created by leipeng on 31/03/2017.
 */
public class HelloWorld {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello from new thread");
            }
        };
        thread.start();
        Thread.sleep(1000);
//        Thread.yield();
        System.out.println("Hello from main thread");
        thread.join();
    }
}
