package com.mukvin.WorkOfferTest.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。*/

public class PrintFromTopToBottom {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Queue<TreeNode> tempRes = new LinkedList<>();
		
		if (root == null) {
			return res;
		}
		
		tempRes.offer(root);
		
		while(!tempRes.isEmpty()) {
			TreeNode currentNode = tempRes.poll();
			res.add(currentNode.val);
			if (currentNode.left != null) {
				tempRes.offer(currentNode.left);
			}
			if (currentNode.right != null) {
				tempRes.offer(currentNode.right);
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}

}
