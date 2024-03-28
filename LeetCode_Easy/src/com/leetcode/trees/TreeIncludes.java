package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeIncludes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(3);
		root.left = new Node(11);
		root.right = new Node(7);
		root.left.left = new Node(4);
		root.left.right = new Node(2);
		root.right.right = new Node(5);
		
		
		System.out.println(treeIncludesWithDFS(root,5));
		System.out.println(treeIncludesWithBFS(root,15));

	}

	private static boolean treeIncludesWithDFS(Node root,int target) {
		// TODO Auto-generated method stub
		if(root == null) {
			return false;
		}
		if(root.val == target) {
			return true;
		}
		return  treeIncludesWithDFS(root.left,target) || treeIncludesWithDFS(root.right,target);
	}
	
	private static boolean treeIncludesWithBFS(Node root,int target) {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node r = queue.poll();
			if(target == r.val) {
				return true;
			}
			if(r.left != null) {
				queue.add(r.left);
			}
			if(r.right != null) {
				queue.add(r.right);
			}
		}
		return  false;
	}

}
