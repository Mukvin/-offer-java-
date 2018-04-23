package com.mukvin.WorkOfferTest.ListAndArrays;

import java.util.HashMap;
/**
 * 题目描述：
 * 输入一个互赞链表（灭国节点中都有节点值，以及两个指针，一个指向下一个节点，另一个特殊的指针指向任意一个节点），返回的结果为复制
 * 后复杂链表的Head。（注意，输出结果中，请不要返回参数中的节点引用，否则判题程序会直接返回空！）
 * @author Mukvin
 *
 */
public class copyListWithRand1 {
	
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	
	public RandomListNode Clone(RandomListNode pHead)
    {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = pHead;
        while(cur !=null) {
        	map.put(cur, new RandomListNode(cur.label));
        	cur = cur.next;
        }
        cur = pHead;
        while(cur != null) {
        	map.get(cur).next =map.get(cur.next);
        	//map.get(cur).next表示复制 next
        	map.get(cur).random = map.get(cur.random);
        	//map.get(cur).random 表示复制任意节点指针
        	cur = cur.next;
        }
        return map.get(pHead);//返回pHead副本 pHead'
    }
	
	public static void main(String[] args) {
		
	}

}
