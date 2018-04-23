package com.mukvin.CodeTest;

import java.util.ArrayList;
import java.util.Stack;

public class PrintValue {

	class ListNode {
		int val;
		ListNode next = null;
		ListNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack =new Stack<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		while(listNode != null) { //不能写成 listNode.next != null,这样的话是默认只有头结点给去掉了
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()) {
			arrayList.add(stack.pop());
		}
		return arrayList;
	}

	public static void main(String[] args) {
		
	}

}
