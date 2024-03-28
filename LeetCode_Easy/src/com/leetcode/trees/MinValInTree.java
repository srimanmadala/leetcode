package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinValInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(3);
		root.left = new Node(11);
		root.right = new Node(7);
		root.left.left = new Node(4);
		root.left.right = new Node(2);
		root.right.right = new Node(5);
		
		
		System.out.println(findMinDFS(root));
		System.out.println(findMinBFS(root));

	}

	private static int findMinDFS(Node root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		int minLeft = findMinDFS(root.left);
		int minRight = findMinDFS(root.right);
		return Math.min(root.val, Math.min(minLeft, minRight));
	}
	
	private static int findMinBFS(Node root) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int minVal = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Node r = queue.poll();
			minVal =  Math.min(minVal, r.val);
			if(r.left != null) {
				queue.add(r.left);
			}
			if(r.right != null) {
				queue.add(r.right);
			}
		}
		return minVal;
	}

}
