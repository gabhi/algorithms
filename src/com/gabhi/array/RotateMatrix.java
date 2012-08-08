/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabhi.array;

import java.util.Arrays;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com>
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] a2 = new int[3][3];
        System.out.println("Initializing Matrix: ");
        initializeArray(a2);
        System.out.println("Original Matrix: ");

        printMatrix(a2);
        System.out.println("Rotating Matrix: ");

        printMatrix((rotateCW(a2)));
        //printMatrix(rotateCW(rotateCW(a2)));


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
        System.out.println("");

    }
    //i dont get it but good for counterclockwise

    public static void initializeArray(int[][] a2) {
        // print array in rectangular form
        int cnt = 1;
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[i].length; j++) {
                a2[i][j] = cnt++;
            }
        }
    }
    //works

    static int[][] rotateCW(int[][] mat) {
        //MxN matrix
        final int M = mat.length;
        final int N = mat[0].length;

        int[][] newMatrix = new int[N][M];

        for (int row = 0; row < M; row++) {
            for (int column = 0; column < N; column++) {
                newMatrix[column][M - 1 - row] = mat[row][column];
            }
        }
        return newMatrix;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
