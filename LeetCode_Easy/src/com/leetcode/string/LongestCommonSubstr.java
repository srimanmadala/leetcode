package com.leetcode.string;

public class LongestCommonSubstr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(longestCommonSubstr("ABCDGH","ACDGHR",6,6));
		//System.out.println(longestCommonSubstr("adac","adadac",4,6));
		//System.out.println(longestCommonSubstrDP("ABCDGH","ACDGHR",6,6));
		System.out.println(longestCommonSubstrDP("adac","adadac",4,6));
	}

	
	//TC: )(n^2) SC:O(n^2)
	private static int longestCommonSubstrDP(String S1, String S2, int n, int m) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n+1][m+1];
		int maxLength = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(S1.charAt(i-1) == S2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
					maxLength = Math.max(maxLength, dp[i][j]);
				}
				
			}
		}
		
		return maxLength;
	}


	
	//TC: n^2 * n O(n^3)  //SC: O(n^2)
	public static int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
		int maxLength = Integer.MIN_VALUE;
		
		for(int i=n-1;i>=0;i--) {
			String n1 = S1.substring(i,n);
			int curentLen = n1.length();
			for(int j=0;j<=m - curentLen;j++) {
				String m1 = S2.substring(j,j+curentLen); //string  contains
				if(n1.equals(m1)) {
					System.out.println(m1);
					maxLength = Math.max(maxLength, m1.length());
				}
			}
		}
		return maxLength;
		    
    }
	
	
}
