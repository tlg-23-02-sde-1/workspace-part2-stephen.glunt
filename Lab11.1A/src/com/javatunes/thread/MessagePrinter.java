/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

import static java.lang.Thread.sleep;

// TODO: extend the Thread class
public class MessagePrinter extends Thread{
    private String message;
    private int count;
    private long interval;

    public MessagePrinter(String message) {
        this.message = message;
        // TODO: set the thread name [important when debugging]
        setName(message);
    }

    public MessagePrinter(String message, long interval){
        this.message = message;
        this.interval = interval;
    }

    /**
     * TODO: implement run() as follows:
     * It should loop 10 times, printing the 'message' field to stdout,
     * then pausing for some interval (in millis) that you choose.
     * <p>
     * Use a try/catch to call Thread.sleep(interval) for the pause.
     * The sleep() method throws InterruptedException, which you need to catch.
     * You can either leave the catch block empty, or print the exception to stdout.
     */
    public void run() {

        while(count < 100){
            System.out.println(message + count);
            count++;
            try {
                sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        for(int i = 0; i < 10; i++){
//            System.out.println(message);
//            try {
//                sleep(interval);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }
}