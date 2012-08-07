/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabhi.array;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com>
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] a2 = new int[3][3];
        System.out.println("Initializing Array: ");
        initializeArray(a2);
        System.out.println("Original Array: ");

        printArray(a2);
        System.out.println("Rotating Array: ");

        printArray((rotateArray(a2)));


    }

    public static int[][] rotateArray(int[][] arr) {

        //first change the dimensions vertical length for horizontal length
        //and viceversa
        int[][] newArray = new int[arr[0].length][arr.length];

        //invert values 90 degrees clockwise by starting from button of
        //array to top and from left to right
        int ii = 0;
        int jj = 0;
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                newArray[i][j] = arr[j][i];
            }
        }

        return newArray;
    }

    public static void printArray(int[][] a2) {
        // print array in rectangular form
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[i].length; j++) {
                System.out.print(" " + a2[i][j]);
            }
            System.out.println("");
        }
    }

    public static void initializeArray(int[][] a2) {
        // print array in rectangular form
        int cnt = 0;
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[i].length; j++) {
                a2[i][j] = cnt++;
            }
         }
    }
}
