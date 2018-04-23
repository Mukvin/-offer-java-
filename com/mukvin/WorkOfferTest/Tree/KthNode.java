package com.mukvin.WorkOfferTest.Tree;

import java.util.Stack;

/*题目描述
给定一颗二叉搜索树，请找出其中的第k大的结点。
例如， 5 
	/ \ 
   3    7 
   /\   /\ 
  2 4   6 8 
  中，按结点数值大小顺序第三个结点的值为4。*/

//思路 ：中序遍历的条件实现,并且注意是返回节点，而不是节点值

public class KthNode {
	int index = 0; // 计数器

	TreeNode KthNode1(TreeNode root, int k) {

		if (root != null) { // 中序遍历寻找第k个
			TreeNode node = KthNode1(root.left, k);
			if (node != null)
				return node;
			index++;
			if (index == k)
				return root;
			node = KthNode1(root.right, k);
			if (node != null)
				return node;
		}
		return null;
	}

	TreeNode KthNode2(TreeNode root, int k) {
		if (root == null || k == 0)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count = 0;
		TreeNode node = root;
		do {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				count++;
				if (count == k)
					return node;
				node = node.right;
			}
		} while (node != null || !stack.isEmpty());
		return null;
	}

	public static void main(String[] args) {

	}

}
