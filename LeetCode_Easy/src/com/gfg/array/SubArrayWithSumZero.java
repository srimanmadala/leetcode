package com.gfg.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = new int[] {1,4,13,-3,-10,5};
		//int[] arr = new int[] {1,4,13,-3,-10,5};
		//int present = brutSubArrayWithSumZero(arr);
		int[] arr = new int[] {3,-1,-2,5};
		int present = subArrayWithSumZero(arr);
		System.out.println("present ::: "+present);

	}

	//TC:O(n^2)  SC:O(1)
	private static int brutSubArrayWithSumZero(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int result = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			int len = Integer.MIN_VALUE;
			int sum= 0;
			for(int j=i;j<n;j++) {
				sum+=arr[j];
				if(sum == 0) {
					len = Math.max(len, j-i+1);
				}
			}
			result = Math.max(len, result);
		}
		return result != Integer.MIN_VALUE ? result : -1;
	}
	
	
	//TC:O(n)  SC:O(1)
	private static int subArrayWithSumZero(int[] arr) {
			// TODO Auto-generated method stub
		Map<Integer,Integer> prefixMap = new HashMap<>();
		int maxLen = Integer.MIN_VALUE;
		int prefixSum = 0;
			int n = arr.length;
			for(int i=0;i<n;i++) {
				prefixSum+=arr[i];
				if(prefixSum == 0) {
					System.out.println("subArrayWithSumZero ::: ("+0 +","+i+")");
					return i;
				}
				if(prefixMap.containsKey(prefixSum)) {
					int index = prefixMap.get(prefixSum);
					int val = index+1;
					System.out.println("subArrayWithSumZero ::: ("+val +","+i+")");
					maxLen = Math.max(maxLen, i-index+1);
					
				}
				prefixMap.put(prefixSum, i);
			}
			return maxLen != Integer.MIN_VALUE ? maxLen : -1;
		}

}
