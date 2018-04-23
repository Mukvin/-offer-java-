package com.mukvin.WorkOfferTest.ListAndArrays;


/*题目描述
输入两个链表，找出它们的第一个公共结点。
剑指offer中的题意，其实这里是没有讲明一个链表是否有环，这里是做了无环处理的，但是如果实际情况，要更想的复杂一些，就是要考虑到有环的情况
谨记！

*/


public class FindFirstCommonNode {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		ListNode loop1 = getLoopNode(pHead1);
		ListNode loop2 = getLoopNode(pHead2);
		if (loop1 == null && loop2 ==null) {
			return NolooplistNode(pHead1, pHead2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoopListNode(pHead1, loop1, pHead2, loop2);
		}
		return null;
	}
	
	//判断一个链表是否有环
	public static ListNode getLoopNode (ListNode head) {
		if (head == null || head.next == null || head.next.next ==null) {
			return null;
		}
		ListNode n1 = head.next; //n1 ->low
		ListNode n2 = head.next.next; // n2 -> fast
		while(n1 != n2) {
			if (n2.next == null || n2.next.next ==null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}//进入循环，如果当有环时候，肯定会有相遇一点，那么就可以弹出了循环了
		n2 =head;
		while( n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;	
		//理论，如果有环的话，那么将fast指针放在head上，low指针不动，这时候，将fast指针设置的步数为1
		//low指针步数不变，那么fast指针和low指针，一定还会相遇，而相遇点点就是第一个入环的节点相遇！
	}
	
	//判断两个无环链表时候相交
	public static ListNode NolooplistNode(ListNode head1 ,ListNode head2) {
		if (head1 ==null || head2 == null) {
			return null;
		}
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		int n = 0;
		while(cur1.next != null) {
			n++;
			cur1= cur1.next;//到末尾节点
		}
		while(cur2.next !=null) {
			n--;
			cur2 =cur2.next;//到末尾节点
		}
		if (cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 :head2;
		cur2 = cur1 ==head1 ? head2 : head1;
		n = Math.abs(n);
		while(n != 0) {
			n--;
			cur1 = cur1.next;
		}
		while(cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	//判断两个有环的链表时是否相交
	public static ListNode bothLoopListNode(ListNode head1 , ListNode loop1 , ListNode head2 , ListNode loop2) {
		ListNode cur1 = null;
		ListNode cur2 = null;
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while(cur1 != loop1) {
				n++;
				cur1= cur1.next;//到loop1
			}
			while(cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 :head1;
			n = Math.abs(n);
			while(n != 0) {
				n--;
				cur1= cur1.next;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}else {
			cur1 = loop1.next;
			while(cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
	
	
	
	public static void main(String[] args) {

	}

}
