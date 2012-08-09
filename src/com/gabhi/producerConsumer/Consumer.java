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
public class Consumer extends Thread {

    private int n;
    private Buffer consBuf;

    public Consumer(int m, Buffer buf) {
        n = m;
        consBuf = buf;
    }

    public void run() {
        int value;
        for (int i = 0; i < n; i++) {
            try {
                value = consBuf.get();
            } catch (InterruptedException e) {
                return;
            }
            try {
                Thread.sleep((int) Math.random() * 100); // sleep for a randomly chosen time
            } catch (InterruptedException e) {
                return;
            }

        }
    }
}
