package com.leetcode.dp;

import java.util.HashMap;
import java.util.List;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println( editDistance("CAT","CUT",3-1,3-1)); //Replace
		//System.out.println( editDistance("GEEK","GEEKS",4-1,5-1));//Add
		//System.out.println( editDistance("SMART","BSMHART",4,5));//Delete
		//System.out.println( editDistance("SATURDAY","SUNDAY",8,6));//Delete
		System.out.println( editDistance("SATURDAY","SUNDAY",8,6, new HashMap<>()));
		System.out.println(editDistanceDP("SATURDAY","SUNDAY",8,6));
		
		
	}
	
	private static int editDistance(String s1, String s2, int m, int n) {
		// TODO Auto-generated method stub
		
		if(m < 0 || n < 0)
			return 0;
		
		if(m == 0 )
			return n;
		if(n == 0 )
			return m;
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			return editDistance( s1,  s2,  m-1,  n-1);
		}
		
		int insert = editDistance( s1,  s2,  m,  n-1);
		int delete = editDistance( s1,  s2,  m-1,  n);
		int replace = editDistance( s1,  s2,  m-1,  n-1);
		
		return 1+Math.min(insert,Math.min(delete, replace));
	}
	

	private static int editDistance(String s1, String s2, int m, int n,
			HashMap<List<Integer>,Integer> memo) {
		// TODO Auto-generated method stub
		
		if(m < 0 || n < 0)
			return 0;
		
		if(m == 0 )
			return n;
		if(n == 0 )
			return m;
		
		List<Integer> pos = List.of(m,n);
		if(memo.containsKey(pos)) {
			return memo.get(pos);
		}
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			return editDistance( s1,  s2,  m-1,  n-1,memo);
		}
		
		int insert = editDistance( s1,  s2,  m,  n-1,memo);
		int delete = editDistance( s1,  s2,  m-1,  n,memo);
		int replace = editDistance( s1,  s2,  m-1,  n-1,memo);
		
		int result = 1+Math.min(insert,Math.min(delete, replace));
		memo.put(pos, result);
		return result;
	}
	
	
	private static int editDistanceDP(String s1, String s2, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			dp[i][0] = i;
		}
		for(int i=0;i<=n;i++) {
			dp[0][i] = i;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1) ) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1], dp[i-1][j]));
				}
			}
		}
		return dp[m][n];
	}
	
	

}
