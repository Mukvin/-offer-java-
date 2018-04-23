package com.mukvin.WorkOfferTest.Stack;

import java.util.Stack;

public class getMinInStack {
	
	private Stack<Integer> stackData ;
	private Stack<Integer> stackMin;
	
    public getMinInStack () {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
    
    public void push(int node) {
        if (this.stackMin.isEmpty()) {
			this.stackMin.push(node);
		}else if (node <= this.min()) {
			this.stackMin.push(node);
		}else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(node);
		}
        this.stackData.push(node);
    }
    
    public int pop() {
        if (this.stackData.isEmpty()) {
			throw new RuntimeException("your stack is empty !");
		}
        this.stackMin.pop();
        return  this.stackData.pop();
    }
    
    public int top() {
    	if (this.stackData.isEmpty()) {
			throw new RuntimeException("your stack is empty !");
		}
        this.stackMin.pop();
        return  this.stackData.pop();
    }
    
    public int min() {
        if (this.stackMin.isEmpty()) {
        	throw new RuntimeException("your stack is empty !");
		}
        return this.stackMin.peek();
    }
}
