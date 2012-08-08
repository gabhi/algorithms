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
package com.gabhi.string;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
public class StringBuilderVsStringBuffer {
    /**
     * StringBuffer is very good with mutable String but it has one disadvantage
     * all its public methods are synchronized which makes it thread-safe but
     * same time slow. In JDK 5 they provided similar class called StringBuilder
     * in Java which is a copy of StringBuffer but without synchronization. Try
     * to use StringBuilder whenever possible it performs better in most of
     * cases than StringBuffer class. You can also use "+" for concatenating two
     * string because "+" operation is internal implemented using either
     * StringBuffer or StringBuilder in Java. If you see StringBuilder vs
     * StringBuffer you will find that they are exactly similar and all API
     * methods applicable to StringBuffer are also applicable to StringBuilder
     * in Java. On the other hand String vs StringBuffer is completely different
     * and there API is also completely different, same is true for
     * StringBuilders vs String.
     *
     *
     * 1) String is immutable while StringBuffer and StringBuilder is mutable
     * object. 2) StringBuffer is synchronized while StringBuilder is not which
     * makes StringBuilder faster than StringBuffer. 3) Concatenation operator
     * "+" is internal implemented using either StringBuffer or StringBuilder.
     * 4) Use String if you require immutability, use Stringbuffer in java if
     * you need mutable + threadsafety and use StringBuilder in Java if you
     * require mutable + without thread-safety.
     *
     */
}
