package com.mukvin.WorkOfferTest.Tree;

import java.util.ArrayList;

/*
 题目描述:
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/

public class GetNext {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;//此处用parent =null 更合适点

		TreeLinkNode(int val) {
			this.val = val;
		}
	}
	
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		
		if (pNode.right != null) {
			return getLeftMost(pNode.right);
		}else {
			TreeLinkNode parent = pNode.next;
			while(parent != null && parent.left != pNode) {
				pNode = parent;
				parent = pNode.next;
			}
			return parent;
		}
	}

	private TreeLinkNode getLeftMost(TreeLinkNode pNode) {
		if (pNode == null) {
			return pNode;
		}
		while(pNode.left != null) {
			pNode = pNode.left;
		}
		return pNode;
	}

	public static void main(String[] args) {

	}

}
