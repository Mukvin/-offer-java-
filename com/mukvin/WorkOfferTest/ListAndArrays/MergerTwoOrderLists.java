package com.mukvin.WorkOfferTest.ListAndArrays;

public class MergerTwoOrderLists {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode Merge(ListNode list1 , ListNode list2) {
		ListNode dummyNode = new ListNode(0);
		ListNode pNode = dummyNode;
		while(list1 !=null && list2 !=null) {
			if (list1.val < list2.val) {
				pNode.next = list1;
				list1 = list1.next;
			}else {
				pNode.next = list2;
				list2 = list2.next;
			}
			pNode = pNode.next;
		}
		if (list1 != null) {
			pNode.next = list1;
		}
		
		if (list2!= null) {
			pNode.next = list2;
		}
		return dummyNode.next;
	}
	
	public static void main(String[] args) {

	}

}
