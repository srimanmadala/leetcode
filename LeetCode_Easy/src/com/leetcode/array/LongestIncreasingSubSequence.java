package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = new int[] {3,4,-1,0,6,2,3,7};
		//int[] arr = new int[] {10,8,7, 6}; //-1
		int[] arr = new int[] {10,2,20,5,7}; // 2 *2* 2* 2* 2 O(2^N)
		List<Integer> lisInts = new ArrayList<>();
		int len = lengthOfLIS(arr,0,lisInts);
		for(Integer val : lisInts) {
			System.out.println(val);
		}
		System.out.println();
		System.out.println(len);

	}

	//TC: // 2 *2* 2* 2* 2 O(2^N) SC:O(N)
	private static int lengthOfLIS(int[] arr, int index,List<Integer> lisInts) {
		// TODO Auto-generated method stub
		
		if(index >= arr.length) {
			return 0;
		}
		
		if(lisInts.isEmpty() || arr[index] > lisInts.get(lisInts.size() - 1)) {
			int countwithoutincluding = lengthOfLIS(arr,index+1,lisInts);
			lisInts.add(arr[index]);
			int countwithIncluding = 1+lengthOfLIS(arr,index+1,lisInts);
			return Math.max(countwithoutincluding, countwithIncluding);
		}
		
		return lengthOfLIS(arr,index+1,lisInts);
	}

}
