package com.gabhi.stack;

import java.util.Stack;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com>
 */
 

//Stack with min 
//design a stack such that getMinimum( ) should be O(1)

public class StackWithMin extends Stack<Integer>
{
    Stack<Integer> localStack;
    
    public StackWithMin(Stack<Integer> stack)
    {
        localStack = stack;
    }
    
    public void push(int value)
    {
        if(value <= min())
        {
            localStack.push(value);
        }
        super.push(value);
        
    }
    
    public Integer pop()
    {
        int value = super.pop();
        if(value == min())
        {
            localStack.pop();
            
        }
        return value;
    }
    
    public int min()
    {
        if(localStack.isEmpty())
        {
            return Integer.MAX_VALUE;
            
        }
        else
        return localStack.peek();
    }


}