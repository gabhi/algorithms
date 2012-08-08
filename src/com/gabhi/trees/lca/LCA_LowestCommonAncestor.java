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
package com.gabhi.trees.lca;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
public class LCA_LowestCommonAncestor {

    TreeNodePtr findLCA(TreeNodePtr root, int p, int q) {

        // no root no LCA.
        if (null == root) {
            return null;
        }

        // if either p or q is the root then root is LCA.
        if (root.data == p || root.data == q) {
            return root;
        } else {
            // get LCA of p and q in left subtree.
            TreeNodePtr leftSubtree = findLCA(root.left, p, q);

            // get LCA of p and q in right subtree.
            TreeNodePtr rightSubtree = findLCA(root.right, p, q);

            // if one of p or q is in leftsubtree and other is in right
            // then root it the LCA.
            if (null != leftSubtree && null != rightSubtree) {
                return root;
            } // else if l is not null, l is LCA.
            else if (null != leftSubtree) {
                return leftSubtree;
            } else {
                return rightSubtree;
            }
        }
    }
}
