package com.leetcode.array;

public class MoveeroesSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[] { 0, 1, 0, 3, 12,0,0,15 };
		//{ 1, 0, 0, 3, 12 }
		//int[] nums = new int[] { 0, 5, 0, 12, 9,0 };
		
		//int[] nums = new int[] { 1,2,3,45,0};
		int nonzeroloc =0;
		int n = nums.length;
		for(int i=0;i<n;i++) {
			if(nums[i] != 0) {
				swap(nums,i,nonzeroloc);
				nonzeroloc++;
			}
			
		}
		
		for(int i=0;i<n;i++) {
			
			System.out.print(nums[i]+" ");
		}

	}

	private static void swap(int[] nums, int i, int nonzeroloc) {
		// TODO Auto-generated method stubms[]
		int tmp = nums[nonzeroloc];
		nums[nonzeroloc] = nums[i];
		nums[i] =  tmp;
		
		
	}

}
