package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfAllNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(3);
		root.left = new Node(11);
		root.right = new Node(7);
		root.left.left = new Node(4);
		root.left.right = new Node(2);
		root.right.right = new Node(5);
		
		
		System.out.println(sumWithDFS(root));
		System.out.println(sumWithBFS(root));

	}

	private static int sumWithDFS(Node root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return 0;
		}
		int sumInLeft = sumWithDFS(root.left);
		int sumInRight = sumWithDFS(root.right);
		return root.val+sumInLeft+sumInRight;
	}
	
	private static int sumWithBFS(Node root) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int sum= 0;
		while(!queue.isEmpty()) {
			Node r = queue.poll();
			sum =  sum+r.val;
			if(r.left != null) {
				queue.add(r.left);
			}
			if(r.right != null) {
				queue.add(r.right);
			}
		}
		return sum;
	}

}
