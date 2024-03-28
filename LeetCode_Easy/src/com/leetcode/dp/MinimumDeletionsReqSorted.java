package com.leetcode.dp;

public class MinimumDeletionsReqSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(5 -  minimumDeletionsReqSorted(new int[] {3,4,2,8,10},0,-1)   );
		System.out.println(8- minimumDeletionsReqSorted(new int[] {4,10,6,5,8,11,2,20},0,-1));
		System.out.println(3- minimumDeletionsReqSorted(new int[] {10,20,30},0,-1));

	}

	private static int minimumDeletionsReqSorted(int[] arr,int index,int pre) {
		
		if(index == arr.length) {
			return 0;
		}
		
		int exl = minimumDeletionsReqSorted(arr,index+1, pre);
		int incl=0;
		if(arr[index] > pre) {
			incl = 1+minimumDeletionsReqSorted(arr, index+1, arr[index]);
		}
		
		return Math.max(exl, incl);
	}

}
