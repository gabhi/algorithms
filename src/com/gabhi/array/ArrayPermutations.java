/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabhi.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com>
 *
 */
public class ArrayPermutations {

    // print N! permutation of the characters of the string s (in order)
    public static void stringPermutations(String input) {
        stringPermutations("", input);
    }

    private static void stringPermutations(String prefix, String input) {
        int N = input.length();

        System.out.println(prefix);
        if (N == 0) {
            //Do nothing
        } else {
            for (int i = 0; i < N; i++) {
                stringPermutations(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1, N));
            }
        }

    }

    public static void main(String[] args) {

        String elements = "abc";
        stringPermutations(elements);
        System.out.println();
    }
}
