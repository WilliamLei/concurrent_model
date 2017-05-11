package com.leipeng.concurrent.model.chapter2;

/**
 * Created by leipeng on 31/03/2017.
 */
public class Counting {
    public static void main(String args[]) throws Exception {
        class Counter {
            private int count = 0;

            public synchronized void increment() {
                ++count;
            }

            public int getCount() {
                return count;
            }
        }

        final Counter counter = new Counter();

        class CountingThread extends Thread {
            @Override
            public void run() {
                for (int x = 0; x < 10000; x++) {
                    counter.increment();
                }
            }
        }

        CountingThread thread1 = new CountingThread();
        CountingThread thread2 = new CountingThread();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.getCount());
    }
}
