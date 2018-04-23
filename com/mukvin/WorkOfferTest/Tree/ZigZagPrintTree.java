package com.mukvin.WorkOfferTest.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
*/

public class ZigZagPrintTree {

	/*
	 * 出错 测试用例: {8,6,10,5,7,9,11}
	 * 
	 * 对应输出应该为: [[8],[10,6],[5,7,9,11]]
	 * 
	 * 你的输出为: [[8],[10,6]]
	 * 初始的位置没有考虑好，而且对于转向液没做好，修改之后正确通过
	 */
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> resLists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tempLists = new ArrayList<Integer>();

		if (pRoot == null) {
			return resLists;
		}

		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		boolean lr = false; // 标记转向  //修改点
		TreeNode last = pRoot;
		TreeNode nLast = null;
		deque.offerFirst(pRoot);
		tempLists.add(pRoot.val);//修改点
		resLists.add(tempLists);//修改点
		tempLists = new ArrayList<>();//修改点
		while (!deque.isEmpty()) {
			if (lr) {
				pRoot = deque.pollFirst();
				// tempLists.add(pRoot.val);//修改点
				if (pRoot.left != null) {
					tempLists.add(pRoot.left.val);
					nLast = nLast == null ? pRoot.left : nLast;
					deque.offerLast(pRoot.left);
				}
				if (pRoot.right != null) {
					tempLists.add(pRoot.right.val);
					nLast = nLast == null ? pRoot.right : nLast;
					deque.offerLast(pRoot.right);
				}
			} else {
				pRoot = deque.pollLast();
				// tempLists.add(pRoot.val);//修改点
				if (pRoot.right != null) {
					tempLists.add(pRoot.right.val);
					nLast = nLast == null ? pRoot.right : nLast;
					deque.offerFirst(pRoot.right);
				}
				if (pRoot.left != null) {
					tempLists.add(pRoot.left.val);
					nLast = nLast == null ? pRoot.left : nLast;
					deque.offerFirst(pRoot.left);
				}
			}

			if (pRoot == last && !deque.isEmpty()) {
				lr = !lr;
				last = nLast;
				nLast = null;

				resLists.add(tempLists);
				tempLists = new ArrayList<Integer>();
			}
		}
		return resLists;
	}

	public static void main(String[] args) {
		TreeNode pRoot = creatingTree.creatingTree1();
		Print(pRoot);
	}

}
