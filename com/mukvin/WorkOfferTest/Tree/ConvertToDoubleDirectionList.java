package com.mukvin.WorkOfferTest.Tree;

import java.util.Stack;

/*题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。*/

//需要重新理解，画图
public class ConvertToDoubleDirectionList {

	/*
	 * 方法一：非递归版 解题思路： 1.核心是中序遍历的非递归算法。 2.修改当前遍历节点与前一遍历节点的指针指向。
	 */
	public TreeNode convert1(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode pre = null;// 用于保存中序遍历序列的上一节点
		boolean isFirst = true;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if (isFirst) {
				root = p;// 将中序遍历序列中的第一个节点记为root
				pre = root;
				isFirst = false;
			} else {
				pre.right = p;
				p.left = pre;
				pre = p;
			}
			p = p.right;
		}
		return root;
	}

	/*
	 * 方法二：递归版 解题思路： 
	 * 1.将左子树构造成双链表，并返回链表头节点。 
	 * 2.定位至左子树双链表最后一个节点。
	 * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。 
	 * 4.将右子树构造成双链表，并返回链表头节点。
	 * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。 
	 * 6.根据左子树链表是否为空确定返回的节点。
	 */

	public TreeNode Convert2(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		// 1.将左子树构造成双链表，并返回链表头节点
		TreeNode left = Convert2(root.left);
		TreeNode p = left;
		// 2.定位至左子树双链表最后一个节点
		while (p != null && p.right != null) {
			p = p.right;
		}
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		if (left != null) {
			p.right = root;
			root.left = p;
		}
		// 4.将右子树构造成双链表，并返回链表头节点
		TreeNode right = Convert2(root.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if (right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left : root;
	}

	/*
	 * 方法三：改进递归版 解题思路： 思路与方法二中的递归版一致，仅对第2点中的定位作了修改，新增一个全局变量记录左子树的最后一个节点。
	 */

	// 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
	protected TreeNode leftLast = null;

	public TreeNode Convert(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			leftLast = root;// 最后的一个节点可能为最右侧的叶节点
			return root;
		}
		// 1.将左子树构造成双链表，并返回链表头节点
		TreeNode left = Convert(root.left);
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		if (left != null) {
			leftLast.right = root;
			root.left = leftLast;
		}
		leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
		// 4.将右子树构造成双链表，并返回链表头节点
		TreeNode right = Convert(root.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if (right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left : root;
	}
	//错误，需要修改
	public TreeNode Convert4(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		TreeNode  last = process(pRootOfTree);
		pRootOfTree = last.right;
		last.right = null;
		return pRootOfTree;
	}

	private TreeNode process(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		TreeNode leftE = process(pRootOfTree.left);//左边结束
		TreeNode rightE = process(pRootOfTree.right);//右边结束
		TreeNode leftS = leftE !=null ? leftE.right : null; // 左边开始
		TreeNode rightS = rightE != null ? rightE : null; //左边结束
		if (leftE != null && rightE != null) {
			leftE.right = pRootOfTree;
			pRootOfTree.left = leftE;
			pRootOfTree.right = rightS;
			rightS.left = pRootOfTree;
			rightE.right = leftE;
			return rightE;
		}else if (leftE != null) {
			leftE.right = pRootOfTree;
			pRootOfTree.left = leftE;
			pRootOfTree.right = leftS;
			return pRootOfTree;
		}else if (rightE != null) {
			pRootOfTree.right = rightS;
			rightS.left = pRootOfTree;
			rightE.right = pRootOfTree;
			return rightE;
		}else {
			pRootOfTree.right = pRootOfTree;
			return pRootOfTree;
		}
	}
	
	public static void main(String[] args) {

	}

}