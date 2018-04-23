package com.mukvin.WorkOfferTest.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
	//先序遍历序列化
	public String Serialize(TreeNode root) {
		if (root == null) {
			return "#!";
		}
		String reString= root.val + "!";
		reString += Serialize(root.left);
		reString += Serialize(root.right);
		return reString;
	}
	//先序遍历反序列化
	public TreeNode Deserialize(String str) {
		String[] value = str.split("!");
		Queue<String> queue = new LinkedList<String>();
		for(int i =  0 ; i != value.length ; i++) {
			queue.offer(value[i]);
		}
		return reconPreOrder(queue);
	}

	private TreeNode reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(value));
		root.left = reconPreOrder(queue);
		root.right = reconPreOrder(queue);
		return root;
	}
}
