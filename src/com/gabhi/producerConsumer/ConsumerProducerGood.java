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

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
import java.util.*;
import java.io.*;

// We would like to synchronize producer and consumer so that
// producer puts a number in the buffer, then the consumer takes it
// out, then the producer puts another number, and so on.
// This solution provides the right behaviour
// We have changed the class Buffer to include wait() and notify()
// We also have changed the producer and cinsumer classes
// slightly to handle a new exception
public class ConsumerProducerGood {

    public static void main(String[] args) {
        Buffer buf = new Buffer();

        // create new threads
        Thread prod = new Producer(10, buf);
        Thread cons = new Consumer(10, buf);

        // starting threads
        prod.start();
        cons.start();

        // Wait for the threads to finish
        try {
            prod.join();
            cons.join();
        } catch (InterruptedException e) {
            return;
        }
    }
}

class Buffer {

    private int contents;
    private boolean empty = true;

    public synchronized void put(int i) throws InterruptedException {
        while (empty == false) { 	//wait till the buffer becomes empty
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        contents = i;
        empty = false;
        System.out.println("Producer: put..." + i);
        notify();
    }

    public synchronized int get() throws InterruptedException {
        while (empty == true) {	//wait till something appears in the buffer
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        empty = true;
        notify();
        int val = contents;
        System.out.println("Consumer: got..." + val);
        return val;
    }
}



