package com.leetcode.array;

public class MaxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Kadens Algorithm
		int[] arr = new int[] {-10,-3,5,9,12,-6,-8}; //14
		//System.out.println(brutemaxSubArraySum(arr));
		//System.out.println(maxSubArraySum(arr));
		System.out.println(findMaxSubArraySumIndexes(arr));

	}

	//TC:O(n^2)  SC:O(1)
	public static int brutemaxSubArraySum(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int max_so_for = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			int sum =arr[i];
			int curent_max = arr[i];
			for(int j=i+1;j<n;j++) {
				sum+=arr[j];
				curent_max = Math.max(curent_max, sum);
			}
			max_so_for = Math.max(max_so_for,curent_max);
		}
		return max_so_for;
	}
	
	
	//TC:O(n)  SC:O(1)
		public static int maxSubArraySum(int[] arr) {
			// TODO Auto-generated method stub
			int n = arr.length;
			int curent_max =arr[0];
			int max_so_for =arr[0];
			for(int i=1;i<n;i++) {
				curent_max = Math.max(arr[i], curent_max+arr[i]);
				max_so_for = Math.max(max_so_for, curent_max);
			}
			return max_so_for;
		}
		
		
		// Find start and end of subarray which has maximum sum.
		//-10,-3,5,9,-6,-8
		public static int findMaxSubArraySumIndexes(int[] arr) {
			// TODO Auto-generated method stub
			int n = arr.length;
			int curent_max =arr[0];
			int max_so_for =arr[0];
			int start = 0, end = 0;
			for(int i=1;i<n;i++) {
				curent_max = curent_max+arr[i];
				if(arr[i] > curent_max) {
					end = i;
					start = i;
					curent_max = arr[i];
				}else {
					end = i;
				}
				
				if(curent_max > max_so_for) {
					max_so_for = curent_max ;
					System.out.println( end - start + 1);
					System.out.println(start + " " + end);
				}
				
			}
			return max_so_for;
		}
		
		

}
