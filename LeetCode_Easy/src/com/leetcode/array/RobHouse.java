package com.leetcode.array;

import java.util.Arrays;

public class RobHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] arr = new int[] {2,1,7,2,1,9};
		int[] arr = new int[] {2,7,9,3,1};
		int n = arr.length;
		int RecMaxAmount =solveRec(arr,n-1);
		//int maxAmount = robHouseRec(arr,0);
		System.out.println("Recursion :::: "+RecMaxAmount);
		
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		int recMemoization =solveRecMemozation(arr,n-1,dp);
		System.out.println("Recursion&&Memoization :::: "+recMemoization);
		
		
		int dpMaxAmount =solveUsingDP(arr);
		System.out.println("DP :::: "+dpMaxAmount);
		
		

	}

	/*private static int robHouseRec(int[] arr, int index) {
		// TODO Auto-generated method stub
		
		if(index < 0  || index >= arr.length) {
			return 0;
		}
		
		int including_i = arr[index]+
		robHouseRec(arr,index-2) + robHouseRec(arr,index+2);
		
		int excluding_i = arr[index-1] + arr[index+1]+
				robHouseRec(arr,index-3) + robHouseRec(arr,index+3);
		
		int excluding_i_1 = arr[index-1] +
				robHouseRec(arr,index-3) + robHouseRec(arr,index+1);
		
		int excluding_i_2 = arr[index+1] +
				robHouseRec(arr,index-1) + robHouseRec(arr,index+3);
		
		
		return Math.max(including_i, Math.max(excluding_i, excluding_i_1+excluding_i_2));
	}*/
	
	 private static  int solveRec(int []nums, int index){
	        // Base Case
	        if(index==0){
	            return nums[0];
	        }
	        if(index<0) return 0;

	        int incl = nums[index] + solveRec(nums, index-2); // When the nums[i] is included
	        int excl = 0 + solveRec(nums, index-1); // When the nums[i] is Excluded

	        return Math.max(incl, excl);
	    }
	 
	 
	 //Memoization
	 private static  int solveRecMemozation(int []nums, int index,int[] dp){
	        // Base Case
	        if(index==0){
	            return nums[0];
	        }
	        if(index<0) return 0;
	        if(dp[index] != -1) {
	        	return dp[index];
	        }

	        int incl = nums[index] + solveRec(nums, index-2); // When the nums[i] is included
	        int excl = 0 + solveRec(nums, index-1); // When the nums[i] is Excluded
	        dp[index] = Math.max(incl, excl);
	        return dp[index];
	    }

	 
	 	//DP
		 private static  int solveUsingDP(int []nums){
			 
			 int[] dp = new int[nums.length];
			 
	        dp[0] = nums[0];
	        dp[1] = Math.max(nums[0], nums[1]);
	        for(int i=2;i<nums.length;i++) {
	        	int incl = dp[i-2]+nums[i];
	        	int excl = 0+dp[i-1];
	        	dp[i] = Math.max(incl, excl);
	        }
		       
		        return dp[nums.length-1];
		    }
		 
		 
		 

}
