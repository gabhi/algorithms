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
package com.gabhi.evaluateExpression;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
//Expression Evautations
//Infix to Postfix Conversion : 
//
//In normal algebra we use the infix notation like a+b*c. The corresponding postfix notation is abc*+. The algorithm for the conversion is as follows :
//Scan the Infix string from left to right.
//Initialise an empty stack.
//If the scannned character is an operand, add it to the Postfix string. If the scanned character is an operator and if the stack is empty Push the character to stack.
//If the scanned character is an Operand and the stack is not empty, compare the precedence of the character with the element on top of the stack (topStack). If topStack has higher precedence over the scanned character Pop the stack else Push the scanned character to stack. Repeat this step as long as stack is not empty and topStack has precedence over the character.
//Repeat this step till all the characters are scanned.
//(After all characters are scanned, we have to add any character that the stack may have to the Postfix string.) If stack is not empty add topStack to Postfix string and Pop the stack. Repeat this step as long as stack is not empty.
//Return the Postfix string.
//Example : 
//
//Let us see how the above algorithm will be imlemented using an example. 
//
//Infix String : a+b*c-d 
//
//Initially the Stack is empty and our Postfix string has no characters. Now, the first character scanned is 'a'. 'a' is added to the Postfix string. The next character scanned is '+'. It being an operator, it is pushed to the stack. 
//
//
//Stack	
//Postfix String
//
//Next character scanned is 'b' which will be placed in the Postfix string. Next character is '*' which is an operator. Now, the top element of the stack is '+' which has lower precedence than '*', so '*' will be pushed to the stack. 
//
//
//Stack	
//Postfix String
//
//The next character is 'c' which is placed in the Postfix string. Next character scanned is '-'. The topmost character in the stack is '*' which has a higher precedence than '-'. Thus '*' will be popped out from the stack and added to the Postfix string. Even now the stack is not empty. Now the topmost element of the stack is '+' which has equal priority to '-'. So pop the '+' from the stack and add it to the Postfix string. The '-' will be pushed to the stack. 
//
//
//Stack	
//Postfix String
//
//Next character is 'd' which is added to Postfix string. Now all characters have been scanned so we must pop the remaining elements from the stack and add it to the Postfix string. At this stage we have only a '-' in the stack. It is popped out and added to the Postfix string. So, after all characters are scanned, this is how the stack and Postfix string will be : 
//
//
//Stack	
//Postfix String
//
//End result :
//Infix String : a+b*c-d
//Postfix String : abc*+d-
public class InfixToPostfix {

    private Stack<String> stack;
    private String infixExp;
    private String postfixExp = "";

    public InfixToPostfix(String exp) {

        String str = "";
        infixExp = exp;
        stack = new Stack<String>();

        for (int i = 0; i < infixExp.length(); i++) {
            /* 
             * If the character is a letter or a digit we append it to the postfix 
             * expression directly. 
             */
            str = infixExp.substring(i, i + 1);
            if (str.matches("[a-zA-Z]|\\d")) {
                postfixExp += str;
            } else if (isOperator(str)) {
                /*
                 * If the stack is empty we directly push the current char into it.
                 */
                if (stack.isEmpty()) {
                    stack.push(str);
                } else {
                    /*
                     * If the current character is an operator, we need to check the stack 
                     * status then, if the stack top contains an operator with lower
                     * precedence, we push the current character in the stack else we pop
                     * the character from the stack and add it to the postfix string. This 
                     * continues till we either find an operator with lower precedence in the 
                     * stack or we find the stack to be empty.
                     */
                    String stackTop = stack.peek();
                    while (getPrecedence(stackTop, str).equals(stackTop) && !(stack.isEmpty())) {
                        postfixExp += stack.pop();
                        if (!(stack.isEmpty())) {
                            stackTop = stack.peek();
                        }
                    }
                    stack.push(str);
                }
            }
        }
        // In the end just append all the operators from the stack to the postfix expression.
        while (!(stack.isEmpty())) {
            postfixExp += stack.pop();
        }
        // Print out the postfix expression
        System.out.println("The postfix form of the expression you entered is: " + postfixExp);
    }

    /*
     * Returns true if 'ch' is an operator, false o/w
     */
    private boolean isOperator(String ch) {

        String operators = "*/%+-";
        if (operators.indexOf(ch) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Returns the operator with higher precedence among 'op1' & 'op2', if they have equal
     * precedence, the first operator in the argument list (op1) is returned.
     */
    private String getPrecedence(String op1, String op2) {

        String multiplicativeOps = "*/%";
        String additiveOps = "+-";

        if ((multiplicativeOps.indexOf(op1) != -1) && (additiveOps.indexOf(op2) != -1)) {
            return op1;
        } else if ((multiplicativeOps.indexOf(op2) != -1) && (additiveOps.indexOf(op1) != -1)) {
            return op2;
        } else if ((multiplicativeOps.indexOf(op1) != -1) && (multiplicativeOps.indexOf(op2) != -1)) {
            return op1;
        } else {
            return op1;
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter an expression in the Infix form:");

        String expression = "a+b*c-d";
        new InfixToPostfix(expression);
    }
}
