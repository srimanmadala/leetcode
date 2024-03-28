package com.leetcode.dp;

import java.util.HashMap;
import java.util.List;

public class MaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<Integer>> grid = List.of(
				  List.of(1,3,12),
				  List.of(5,6,2)
				);
		
		
		System.out.println(maxPathSum(0,0,grid));
		System.out.println(maxPathSum(0,0,grid, new HashMap<>()));
		//System.out.println(countPaths(0,0,grid,new HashMap<>()));
	}
	
	//TC: O(2^r+c) SC-O(height of the tree - r*c)
	public static int maxPathSum(int r,int c,List<List<Integer>> grid) {
		
		if(r>=grid.size() || c>=grid.get(0).size()) {
	    	return 0;
	    }
		

	    if(r==grid.size()-1 && c==grid.get(0).size()-1) {
	    	return grid.get(r).get(c);
	    }
	    
	    
	    return grid.get(r).get(c)+Math.max(maxPathSum(r+1,c,grid) , maxPathSum(r,c+1,grid));
	  }
	
	
	
	public static int maxPathSum(int r,int c,List<List<Integer>> grid,HashMap<List<Integer>,Integer> memo) {
		
		if(r>=grid.size() || c>=grid.get(0).size()) {
	    	return 0;
	    }
		

	    if(r==grid.size()-1 && c==grid.get(0).size()-1) {
	    	return grid.get(r).get(c);
	    }
	    
	    List<Integer> position = List.of(r,c);
	    if(memo.containsKey(position)) {
	    	return memo.get(position);
	    }
	    
	    int pathSum = grid.get(r).get(c)+Math.max(maxPathSum(r+1,c,grid,memo) , maxPathSum(r,c+1,grid,memo));
	    memo.put(position, pathSum);
	    return pathSum;
	  }
	
	
	
	

}
