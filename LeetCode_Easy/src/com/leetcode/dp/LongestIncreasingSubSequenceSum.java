package com.leetcode.dp;

public class LongestIncreasingSubSequenceSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println( longestIncreasingSubSequenceSum(new int[] {4,10,6,5,8,11,2,20},0.-1));
		//System.out.println( longestIncreasingSubSequenceSum(new int[] {3,4,2,8,10},0,-1));
		System.out.println( longestIncreasingSubSequenceSum(new int[] {4,10,6,5,8,11,2,20},0,-1));
		System.out.println( longestIncreasingSubSequenceSumMemo(new int[] {4,10,6,5,8,11,2,20}));
	}

	
	
	private static int longestIncreasingSubSequenceSum(int[] arr,int index,int prev) {
		if(index == arr.length) {
			return 0;
		}
		
		int exl = longestIncreasingSubSequenceSum(arr,index+1, prev);
		int incl = 0;
		if(arr[index] > prev) {
			incl = arr[index]+longestIncreasingSubSequenceSum(arr,index+1, arr[index]);
		}
		
		return Math.max(exl, incl);
		
	}
	
	
	
	
	//TC: O(n^2)   SC:O(n)
	private static int longestIncreasingSubSequenceSumMemo(int[] arr) {
		int[] dp = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			dp[i] = arr[i];
		}

		int maxVal = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			int initialVal = arr[i];
			for (int j = 0; j < i; j++) {
				if (dp[j] < dp[i]) {
					dp[i] = Math.max(dp[i], initialVal+dp[j]);
					maxVal = Math.max(maxVal, dp[i]);
				}

			}
		}
		return maxVal;
	}
	 
	 
	

}
