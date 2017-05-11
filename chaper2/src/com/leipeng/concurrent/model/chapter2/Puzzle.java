package com.leipeng.concurrent.model.chapter2;

/**
 * Created by leipeng on 11/05/2017.
 */
public class Puzzle {

    static boolean answerReady = false;

    static int answer = 0;

    static Thread t1 = new Thread() {
        public void run() {
            answer = 42;
            answerReady = true;
        }
    };

    static Thread t2 = new Thread() {
        @Override
        public void run() {
            if (answerReady) {
                System.out.println("The meaning of life is: " + answer);
            } else {
                System.out.println("I don't know the answer");
            }
        }
    };

    public static void main(String[] args) throws Exception {
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }


}
