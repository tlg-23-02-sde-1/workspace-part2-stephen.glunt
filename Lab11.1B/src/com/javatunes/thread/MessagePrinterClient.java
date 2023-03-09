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
    // DONE: create two instances of your thread subclass and start them up
    MessagePrinter printer1 = new MessagePrinter("Roses are red");  // take the default interval
    Thread thd1 = new Thread(printer1, "messagePrinter: 01");
    MessagePrinter printer2 = new MessagePrinter("Violets are blue", 375);
    Thread thd2 = new Thread(printer2, "messagePrinter: 02");
    MessagePrinter printer3 = new MessagePrinter("Sugar is sweet", 150);
    Thread thd3 = new Thread(printer3, "messagePrinter: 03");
    MessagePrinter printer4 = new MessagePrinter("But not as sweet as Blues Clues", 200);
    Thread thd4 = new Thread(printer4, "messagePrinter: 04");
    
    thd1.start();
    thd2.start();
    thd3.start();
    thd4.start();
    
    // just for demonstration purposes - this shows why you don't call run() directly
    // printer1.run();
    // printer2.run();
  }
}