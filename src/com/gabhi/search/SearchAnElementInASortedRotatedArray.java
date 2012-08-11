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
package com.gabhi.search;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
public class SearchAnElementInASortedRotatedArray {

    public SearchAnElementInASortedRotatedArray() {
    }

    public static int pivotedBinarySearch(int[] a, int n, int k) {
        int pivot = findPivot(a, 0, n - 1);

        if (pivot != -1) {
            if (a[pivot] == k) {
                return pivot;
            } else if (a[0] <= k) {
                return binarySearch(a, 0, pivot - 1, k);
            } else {
                return binarySearch(a, pivot + 1, n - 1, k);
            }
        }

        return -1;
    }

    public static int findPivot(int[] a, int low, int high) {
        if (high >= low) {
            int mid = (low + high) / 2;

            if (a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[low] > a[mid]) {
                return findPivot(a, low, mid - 1);
            } else {
                return findPivot(a, mid + 1, high);
            }
        }

        return -1;
    }

    
    public static int binarySearch(int[] a, int low, int high, int k) {
        if (high >= low) {
            int mid = (low + high) / 2;

            if (a[mid] == k) {
                return mid;
            } else if (a[mid] > k) {
                return binarySearch(a, low, mid - 1, k);
            } else {
                return binarySearch(a, mid + 1, high, k);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        //  Input Array
        int[] a = {3, 4, 5, 6, 1, 2};

        //  k - Element to be found
        int k = 1;

        //  n - Size of the array
        int n = 6;
        System.out.println(pivotedBinarySearch(a, n, k));
    }
}