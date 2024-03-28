package com.leetcode.dp;

import java.util.HashMap;
import java.util.List;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( longestCommonSubSequence("AXYZ","BAZ",4-1,3-1));
		System.out.println( longestCommonSubSequence("BAXYZ","BXAZ",5-1,4-1));
		
		
		System.out.println( longestCommonSubSequence("AXYZ","BAZ",4-1,3-1,new HashMap<>()));
		System.out.println( longestCommonSubSequence("BAXYZ","BXAZ",5-1,4-1,new HashMap<>()));
	}

	private static int longestCommonSubSequence(String s1, String s2, int m, int n) {
		// TODO Auto-generated method stub
		
		if(m < 0 || n < 0)
			return 0;
		
		if(s1.charAt(m) == s2.charAt(n)) {
			return 1+longestCommonSubSequence( s1,  s2,  m-1,  n-1);
		}
		
		return Math.max(longestCommonSubSequence( s1,  s2,  m-1,  n), 
				longestCommonSubSequence( s1,  s2,  m,  n-1));
	}
	
	private static int longestCommonSubSequence(String s1, String s2, int m, int n,
			HashMap<List<Integer>,Integer> memo) {
		// TODO Auto-generated method stub
		
		if(m < 0 || n < 0)
			return 0;
		List<Integer> pos = List.of(m,n);
		if(memo.containsKey(pos)) {
			return memo.get(pos);
		}
		if(s1.charAt(m) == s2.charAt(n)) {
			return 1+longestCommonSubSequence( s1,  s2,  m-1,  n-1);
		}
		
		int result = Math.max(longestCommonSubSequence( s1,  s2,  m-1,  n), 
				longestCommonSubSequence( s1,  s2,  m,  n-1));
		memo.put(pos, result);
		return result;
	}

}
