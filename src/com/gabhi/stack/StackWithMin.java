package com.gabhi.stack;

import java.util.Stack;

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
/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
//Stack with min 
//design a stack such that getMinimum( ) should be O(1)
public class StackWithMin extends Stack<Integer> {

    Stack<Integer> localStack;

    public StackWithMin(Stack<Integer> stack) {
        localStack = stack;
    }

    public void push(int value) {
        if (value <= min()) {
            localStack.push(value);
        }
        super.push(value);

    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            localStack.pop();

        }
        return value;
    }

    public int min() {
        if (localStack.isEmpty()) {
            return Integer.MAX_VALUE;

        } else {
            return localStack.peek();
        }
    }
}