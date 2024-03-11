package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MaxErasureValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = new int[] {4,2,4,5,6}; 
		int[] arr = new int[] {5,2,1,2,5,2,1,2,5}; 
		//System.out.println(brutemaxSubArraySum(arr));
		//System.out.println(maxSubArraySum(arr));
		System.out.println(maxErasureValue(arr));

	}

	//TC:O(n^2)  SC:O(1)
	public static int maxErasureValue(int[] nums) {
		
		 int n = nums.length;
			int max_sum_so__for = Integer.MIN_VALUE;
			Map<Integer,Integer> indexMap = new HashMap<>();
	        int[] prefix_sum = new int[nums.length];
	        
	        prefix_sum[0] = nums[0];
	        for(int i=1;i<n;i++) {
	        	prefix_sum[i] = prefix_sum[i-1]+nums[i];
	        }
	        int start = 0;
	        int cur_sum = 0;
			for(int i=0;i<n;i++) {
				if(indexMap.containsKey(nums[i])) {
					int indx = indexMap.get(nums[i]);
					if(start <= indx) {
						cur_sum = prefix_sum[i] - prefix_sum[indx];
						start = indx+1;
					}
					max_sum_so__for = Math.max(max_sum_so__for, cur_sum);
				}
				cur_sum+=nums[i];
				indexMap.put(nums[i], i);
			}
			return Math.max(max_sum_so__for, cur_sum);
	}
	
	
	
		
		

}
