package com.mukvin.WorkOfferTest.ListAndArrays;
/*
 * 在链表当中找到找出倒数第k的数
 * 
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindKNum {
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k < 1) {
			return head;
		}
		
		ListNode cur = head;
		while(cur != null) {
			k -- ;
			cur = cur.next;
		}
		
		if (k == 0 ) {
			cur = head;
		}
		
		if (k < 0) {
			cur = head;
			while(++ k != 0) {
				cur = cur.next;
			}
		}
		return cur;
	}

	public static void main(String[] args) {
		
	}

}
