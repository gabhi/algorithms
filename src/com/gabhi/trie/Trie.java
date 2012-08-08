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
package com.gabhi.trie;

import java.util.Collection;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
public class Trie {

    private Node root;

    public Trie() {
        root = new Node(' ');
    }

    public void insert(String s) {
        Node current = root;
        if (s.length() == 0) //For an empty character
        {
            current.marker = true;
        }
        for (int i = 0; i < s.length(); i++) {
            Node child = current.subNode(s.charAt(i));
            if (child != null) {
                current = child;
            } else {
                current.child.add(new Node(s.charAt(i)));
                current = current.subNode(s.charAt(i));
            }
            // Set marker to indicate end of the word
            if (i == s.length() - 1) {
                current.marker = true;
            }
        }
    }

    public boolean search(String s) {
        Node current = root;
        while (current != null) {
            for (int i = 0; i < s.length(); i++) {
                if (current.subNode(s.charAt(i)) == null) {
                    return false;
                } else {
                    current = current.subNode(s.charAt(i));
                }
            }
            /* 
             * This means that a string exists, but make sure its
             * a word by checking its 'marker' flag
             */
            if (current.marker == true) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}