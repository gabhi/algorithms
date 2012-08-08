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
package com.gabhi.subsetsum;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
//Given a target sum, find if there is a pair of element in the given array which sums up to it
public class SubsetSumToX {

    //Algorithm
//    1)sort the array
//    2) iterate from the start and for each element
//
//    3) calculate the required complement (sum - element)
//    4) do a reverse binary search (from the end of the sorted array) looking for that precise value
//
//    5) if found, remove both
    //Complexity is O(n)
    public static void findPairWithTargetSum(int[] inputArray, int targetSum) {
        //assumption Array is sorted if not sort the array first

        int startPtr = 0, endPtr = inputArray.length - 1, sum;
        while (startPtr < endPtr) {
            sum = inputArray[startPtr] + inputArray[endPtr];
            if (sum == targetSum) {
                report_pair(inputArray[startPtr], inputArray[endPtr]);
                endPtr--;
                startPtr++;
            } else if (sum < targetSum) {
                startPtr++;
            } else {
                endPtr--;
            }
        }


    }

    private static void report_pair(int a, int b) {
        System.out.println(a + ", " + b);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        findPairWithTargetSum(nums, 7);
    }
}
