package com.mukvin.WorkOfferTest.ListAndArrays;

/**
 * 题目描述：输入一个互赞链表（灭国节点中都有节点值，以及两个指针，一个指向下一个节点，另一个特殊的指针指向任意一个节点）
 * ，返回的结果为复制后复杂链表的Head。（注意，输出结果中，请不要返回参数中的节点引用，否则判题程序会直接返回空！）                     
 * @author Mukvin
 *
 */
public class copyListWithRand2 {
	
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
        if (pHead == null) {
			return null;
		}
        RandomListNode cur = pHead;
        RandomListNode next = null;
        //复制并链接每一个节点,形成如1-> 1'->2 ->2' ->3 ->3'->null的形式
        while(cur != null) {
        	next = cur.next; //复制cur.next的节点
        	cur.next = new RandomListNode(cur.label);//生成复制节点
        	cur.next.next = next; //连接 1'-> 2 
        	cur =next; //cur 标记原先的原本数
        }
        cur = pHead;
        RandomListNode curCopy = null;
        //设置复制节点的random指针
        while(cur != null){
        	next = cur.next.next; //标记next永远是原本数连接
        	curCopy =cur.next;
        	curCopy.random = cur.random !=null ? cur.random.next :null;
        	//这里如果1的random 指针指向的是3 ，那么1'的random正好指向就是 3的next,也即 1.random = 3 3.next 就是3'
        	cur = next ;
        }
        RandomListNode res = pHead.next;
        cur = pHead;
        //原先将复制连接和合并在一块，现在要拆分出来，res就是得到了是复制链
        while(cur != null) {
        	next = cur.next.next;
        	curCopy  =cur.next;
        	cur.next = next;//将原本数连接也连接
        	curCopy.next = next != null ? next.next : null;//将复制链拼接起来
        	cur = cur.next;
        }
        return res;//res指向就是cur.next的位置，切记，不要记忆深刻，这里就是代表个位置
    }
	
	public static void main(String[] args) {
		
	}

}
