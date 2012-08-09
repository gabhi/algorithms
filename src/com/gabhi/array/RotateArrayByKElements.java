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
package com.gabhi.array;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
public class RotateArrayByKElements {

//    split the Array in to 2 parts A[0-n] : 
    //A[0-K]  =>B 
    //A[K+1:n] =>C
//A=BC
//reverse B and C
//new A =B'C'
//reverse A now you'll get CB hence rotated :)..
//rotate(arr[], d, n)
//  reverse(arr[], 1, d) ;
//  reverse(arr[], d + 1, n);
//  reverse(arr[], l, n);
    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    static void printArray(int arr[]) {
        int i;
        for (i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /* Function to left rotate inputArray[]   by k */
    static void leftRotate(int inputArray[], int k) {
        int size = inputArray.length;
        revereseArray(inputArray, 0, k - 1);
        revereseArray(inputArray, k, size - 1);
        revereseArray(inputArray, 0, size - 1);
    }

    /*Function to reverse inputArray[] from index start to end*/
    static void revereseArray(int inputArray[], int start, int end) {
        int i;
        int temp;
        while (start < end) {
            temp = inputArray[start];
            inputArray[start] = inputArray[end];
            inputArray[end] = temp;
            start++;
            end--;
        }
    }

    /* Driver program to test above functions */
    public static void main(String[] argss) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        leftRotate(arr, 2);
        printArray(arr);

    }
}
