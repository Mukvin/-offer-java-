package com.mukvin.WorkOfferTest.ListAndArrays;

/*题目描述
一个链表中包含环，请找出该链表的环的入口结点。
*/


public class EntryNodeOfLoop {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		
		if (pHead == null || pHead.next == null || pHead.next.next ==null) {
			return null;
		}
		ListNode n1 = pHead.next; //n1 ->low
		ListNode n2 = pHead.next.next; // n2 -> fast
		while(n1 != n2) {
			if (n2.next == null || n2.next.next ==null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}//进入循环，如果当有环时候，肯定会有相遇一点，那么就可以弹出了循环了
		n2 =pHead;
		while( n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;	
		//理论，如果有环的话，那么将fast指针放在head上，low指针不动，这时候，将fast指针设置的步数为1
		//low指针步数不变，那么fast指针和low指针，一定还会相遇，而相遇点点就是第一个入环的节点相遇！
	}

	public static void main(String[] args) {

	}

}
