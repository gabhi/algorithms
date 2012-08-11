package com.gabhi.array;

import java.util.ArrayList;
import java.util.List;

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
        stringPermutations(
                prefix + input.charAt(i),
                input.substring(0, i) + input.substring(i + 1, N));
      }
    }

  }

  public static void main(String[] args) {

    String elements = "abc";
    stringPermutations(elements);
    System.out.println();
  }
}
