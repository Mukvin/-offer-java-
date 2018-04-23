package com.mukvin.WorkOfferTest.Stack;

import java.util.Stack;


public class getMinInStackTrue {
	
	
	Stack<Integer> stack = new Stack<Integer>();  
	Stack<Integer> minStack = new Stack<Integer>();  
    int min = Integer.MAX_VALUE;  
    public void push(int x) {  
        stack.push(x);  
        if (min >= x) {  
            min = x;  
            minStack.push(min);  
        }  
    }  
  
    public void pop() {  
        if (min == stack.peek()) {  
            minStack.pop();  
            if (minStack.isEmpty()) {  
                min = Integer.MAX_VALUE;  
            } else {  
                min = minStack.peek();  
            }  
        }  
        stack.pop();  
    }  
  
    public int top() {  
        return stack.peek();  
    }  
  
    public int min() {  
        return min;  
    }  
	
}
