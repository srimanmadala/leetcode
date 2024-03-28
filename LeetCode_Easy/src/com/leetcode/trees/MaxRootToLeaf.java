package com.leetcode.trees;

public class MaxRootToLeaf {

	public static void main(String[] args) {
		
		Node root = new Node(5);
		root.left = new Node(11);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(2);
		root.right.right = new Node(1);
		//root.right.right = new Node(5);
		
		System.out.println(maxRootLeafWithDFS(root));
		//System.out.println(sumWithBFS(root));
	}

	private static int maxRootLeafWithDFS(Node root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return 0;
		}
		int sumInLeft = maxRootLeafWithDFS(root.left);
		int sumInRight = maxRootLeafWithDFS(root.right);
		return root.val+Math.max(sumInLeft, sumInRight);
	}
	

}
