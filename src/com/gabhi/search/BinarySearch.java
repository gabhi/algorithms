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
package com.gabhi.search;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com>
 */
//Implement Binary Search
/**
 * A straightforward implementation of binary search is recursive. The initial
 * call uses the indices of the entire array to be searched. The procedure then
 * calculates an index midway between the two indices, determines which of the
 * two subarrays to search, and then does a recursive call to search that
 * subarray. Each of the calls is tail recursive, so a compiler need not make a
 * new stack frame for each call. The variables imin and imax are the lowest and
 * highest inclusive indices that are searched.
 *
 */
public class BinarySearch {

    public static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        int SIZE = 8;
        Comparable[] a = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            a[ i] = new Integer(i * 2);
        }

        for (int i = 0; i < SIZE * 2; i++) {
            System.out.println("Found " + i + " at "
                    + binarySearch(a, new Integer(i)));
        }

    }

    public static int binarySearch(Comparable[] a, Comparable x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a[ mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[ mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return NOT_FOUND;     // NOT_FOUND = -1
    }
}
