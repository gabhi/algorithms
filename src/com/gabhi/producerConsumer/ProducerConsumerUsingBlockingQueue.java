/*
 * The MIT License
 *
 * Copyright 2012 Abhijit Gaikwad <gaikwad.abhijit@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.gabhi.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
public class ProducerConsumerUsingBlockingQueue {

  static BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);

  public static void main(String[] args) {
    try {
      System.out.println("Producer Consumer using Built in ");
      System.out.println("Q size:  " + q.size());
      Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
          produce();
        }
      });

      Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
          consume();
        }
      });


      t1.start();
      t2.start();;

      t1.join();
      t2.join();
    } catch (InterruptedException ex) {
      Logger.getLogger(ProducerConsumerUsingBlockingQueue.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public static void produce() {
    try {

      Random r = new Random();
      while (true) {
        q.put(r.nextInt(100));

      }
    } catch (InterruptedException ex) {
      System.out.println(ProducerConsumerUsingBlockingQueue.class.getName() + ex);
    }

  }

  public static void consume() {
    try {
      Random r1 = new Random();
      while (true) {
        int c = r1.nextInt(5);

        if (c == 0) {
          System.out.println("Reading from Q: " + q.take() + " Q: " + q);
        }
      }
    } catch (InterruptedException ex) {
      System.out.println(ProducerConsumerUsingBlockingQueue.class.getName() + ex);
    }
  }
}
