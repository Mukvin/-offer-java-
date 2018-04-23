package com.mukvin.WorkOfferTest.Tree;

public class creatingTree {
	
	
	//错误
	public static TreeNode creatingTree1() {
		TreeNode pRoot = new TreeNode(1);

		TreeNode secNode = new TreeNode(2);
		secNode = pRoot.left;
		
		TreeNode thirdNode = new TreeNode(3);
		thirdNode = pRoot.right;
		//thirdNode.val = 3;
		
		TreeNode fourthNode = new TreeNode(4);
		fourthNode = secNode.left;
		//fourthNode.val = 4;
		
		TreeNode fifthNode = new TreeNode(5);
		fifthNode = thirdNode.left;
		//fifthNode.val = 5;
		
		TreeNode sisthNode = new TreeNode(6);
		sisthNode = thirdNode.right;
		//sisthNode .val = 6;
		
		TreeNode seventhNode = new TreeNode(7);
		seventhNode = fifthNode.left;
		//seventhNode.val = 7;
		
		TreeNode eighthNode = new TreeNode(8);
		eighthNode = fifthNode.right;
		//eighthNode.val = 8;
		
		return pRoot;
	}
	

}
