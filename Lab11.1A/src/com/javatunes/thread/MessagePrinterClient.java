/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

    public static void main(String[] args) {
        // TODO: create two instances of your thread subclass and start them up
      MessagePrinter alpha = new MessagePrinter("This is alpha", 2);
      MessagePrinter omega = new MessagePrinter("this     is omega".toUpperCase(), 3);
        alpha.run();
        omega.run();
    }
}