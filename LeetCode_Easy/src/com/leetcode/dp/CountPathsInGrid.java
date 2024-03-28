package com.leetcode.dp;

import java.util.HashMap;
import java.util.List;

public class CountPathsInGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> grid = List.of(
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O")
				);
				//Source.countPaths(grid); // -> 145422675 
		
		List<List<String>> grid5 = List.of(
				  List.of("O", "O", "X", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "X"),
				  List.of("X", "O", "O", "O", "O", "O"),
				  List.of("X", "X", "X", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O")
				);
				//Source.countPaths(grid); // -> 42
		
		List<List<String>> grid3 = List.of(
				  List.of("O", "O", "X", "O", "O", "O"),
				  List.of("O", "O", "X", "O", "O", "O"),
				  List.of("X", "O", "X", "O", "O", "O"),
				  List.of("X", "X", "X", "O", "O", "O"),
				  List.of("O", "O", "O", "O", "O", "O")
				);
				//Source.countPaths(grid); // -> 0
		
		List<List<String>> grid1 = List.of(
				  List.of("O", "O"),
				  List.of("O", "O")
				);//2
		
		List<List<String>> grid2 = List.of(
				  List.of("O", "O", "O"),
				  List.of("O", "O", "X"),
				  List.of("O", "O", "O")
				);
				//Source.countPaths(grid); // -> 3
		
		
		List<List<String>> grid4 = List.of(
				  List.of("O", "O", "X"),
				  List.of("O", "O", "O"),
				  List.of("O", "O", "O")
				); //  5
		//System.out.println(countPaths(0,0,grid));
		System.out.println(countPaths(0,0,grid,new HashMap<>()));
	}
	
	public static int countPaths(int r,int c,List<List<String>> grid) {
		
		if(r>=grid.size() || c>=grid.get(0).size()) {
	    	return 0;
	    }
		
	    if(grid.get(r).get(c).equals("X")) {
	    	return 0;
	    }

	    if(r==grid.size()-1 && c==grid.get(0).size()-1) {
	    	return 1;
	    }
	    
	    
	    return countPaths(r+1,c,grid) + countPaths(r,c+1,grid);
	  }
	
	
public static int countPaths(int r,int c,List<List<String>> grid,HashMap<List<Integer>,Integer> memo) {
		
		if(r>=grid.size() || c>=grid.get(0).size()) {
	    	return 0;
	    }
	    if(r==grid.size()-1 && c==grid.get(0).size()-1) {
	    	return 1;
	    }
	    
	    if(grid.get(r).get(c).equals("X")) {
	    	return 0;
	    }
	   List<Integer> pos = List.of(r,c);
	    if(memo.containsKey(pos)) {
	    	return memo.get(pos);
	    }
	    
	    int paths =  countPaths(r+1,c,grid) + countPaths(r,c+1,grid);
	    memo.put(pos, paths);
	    return paths;
	  }
	
	

}
