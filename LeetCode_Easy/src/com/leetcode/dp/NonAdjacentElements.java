package com.leetcode.dp;

public class NonAdjacentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {2,4,5,12,7};
		System.out.println(nonAdjacentSum(arr.length-1,arr));
	}
	
	private static int nonAdjacentSum(int index, int[] arr) {
		
		if(index < 0) {
			return 0;
		}
		
		int incl = arr[index] + nonAdjacentSum( index-2,arr);
		int excl = 0 + nonAdjacentSum( index-1,arr);
		return Math.max(incl,excl) ;
	}

}
