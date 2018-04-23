package com.mukvin.WorkOfferTest.Tree;


/*题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*/


public class IsBalanced {
	
	public boolean IsBalanced_Solution(TreeNode root) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(root ,1 ,res);
		return res[0];//res[]的长度为1、定义为全局变量，如果不平衡就位false
	} 

	private int getHeight(TreeNode root, int level, boolean[] res) {
		if (root == null) {
			return level;
		}
		
		int lH = getHeight(root.left, level+1, res);
		if (!res[0]) {
			return level;//返回高度
		}
		
		int rH = getHeight(root.right, level+1, res);
		if (!res[0]) {
			return level;
		}
		
		if (Math.abs(lH  - rH)> 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

	public static void main(String[] args) {
		
	}

}
