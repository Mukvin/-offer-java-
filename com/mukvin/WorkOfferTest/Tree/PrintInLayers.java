package com.mukvin.WorkOfferTest.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/

public class PrintInLayers {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	// 法一，错误，需要调试
	public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> layerRes = new ArrayList<Integer>();
		if (pRoot == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode last = pRoot;
		TreeNode nLast = null;

		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			pRoot = queue.poll();
			layerRes.add(pRoot.val);
			if (pRoot.left != null) {
				queue.offer(pRoot.left);
				nLast = pRoot.left;
			}
			if (pRoot.right != null) {
				queue.offer(pRoot.right);
				nLast = pRoot.right;
			}
			if (pRoot == last && !queue.isEmpty()) {
				last = nLast;
				res.add(layerRes);
				layerRes = new ArrayList<Integer>();
			}
		}
		return res;
	}
	//法二：类似法一 替换了last 和 nlast 标记
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		Queue<TreeNode> layer = new LinkedList<TreeNode>();
		ArrayList<Integer> layerList = new ArrayList<Integer>();
		layer.add(pRoot);
		int start = 0, end = 1;
		while (!layer.isEmpty()) {
			TreeNode cur = layer.remove();
			layerList.add(cur.val);
			start++;
			if (cur.left != null) {
				layer.add(cur.left);
			}
			if (cur.right != null) {
				layer.add(cur.right);
			}
			if (start == end) {
				end = layer.size();//需要明白的是这个地方的end  下一层巧妙的用layer.size()表示,需要再理解，这个位置才是最骚的
				start = 0;
				result.add(layerList);
				layerList = new ArrayList<Integer>();
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
