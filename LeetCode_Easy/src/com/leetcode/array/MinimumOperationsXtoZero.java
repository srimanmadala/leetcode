package com.leetcode.array;

public class MinimumOperationsXtoZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] arr = new int[] {1,3,1,20,1,2,2};
		//System.out.println( minimumOperationsXtoZero(new int[] {1,3,1,20,1,2,2},10));
		System.out.println( minimumOperationsXtoZero(new int[] {8,5,12,11,9},7));
		System.out.println( minimumOperationsXtoZero(new int[] {1,2,3,5},12));
		System.out.println( minimumOperationsXtoZero(new int[] {1,2,3,5},11));
	}

	/**
	 * Operations include - adding element either from leftmost or rightmost of the array.
	 * Once added the array is reduced (array - positive integers)
	 * @param arr
	 * @param X
	 * @return
	 */ 
	private static int minimumOperationsXtoZero(int[] arr, int X) {
		// TODO Auto-generated method stub
		int target = -X;
		int start=0,end=0,running_sum=0;
		int result = Integer.MAX_VALUE;
		
		for(end=0;end<arr.length;end++) {
			target+=arr[end];
		}
		if(target == 0) {
			return arr.length;
		}
		
		if(target < 0)return -1;
		
		for(end=0;end<arr.length;end++) {
			running_sum+=arr[end];
			while(running_sum > target) {
				running_sum-=arr[start];
				start++;
			}
			if(running_sum == target) {
				result = Math.min(result,end-start+1);
			}
		}
		return result == Integer.MAX_VALUE ? -1 :  arr.length - result;
	}

}
