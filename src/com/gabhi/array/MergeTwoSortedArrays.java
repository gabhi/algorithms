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
public class MergeTwoSortedArrays {

        public static void main(String[] args)
        {
            int []a =new int[7];
            a[0]=5;a[1]=7;a[2]=8;
            int []b={1,2,6,9};
            bufferMerge(a,b,3,4);
        }
    //Following function merges 2 arrays into the single one without creating 3rd array
    public static void bufferMerge(int[] A, int[] B,
            int sizeAdata, int sizeB) {
        // Assume sizeAdata + sizeB = A.length
        // i.e., B exactly fits into the buffer at the end of A
        int k = A.length - 1; // Index of last location of array A
        int i = sizeAdata - 1;// Index of last element in array A
        int j = sizeB - 1;// Index of last element in array B

        // Start comparing from the last element and merge A and B
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
        
        for(int m=0;m<A.length;m++)
        {
            
            System.out.println(A[m]);
        }
    }
    //Following function creates a third array for mergin arrays
    public static int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                answer[k++] = a[i++];
            } else {
                answer[k++] = b[j++];
            }
        }

        while (i < a.length) {
            answer[k++] = a[i++];
        }


        while (j < b.length) {
            answer[k++] = b[j++];
        }

        return answer;
    }
}
