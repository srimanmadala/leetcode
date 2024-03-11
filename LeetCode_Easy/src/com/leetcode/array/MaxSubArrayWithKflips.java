package com.leetcode.array;

public class MaxSubArrayWithKflips {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] arr = new int[] {0,0,1,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		//int[] arr = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		//int[] arr = new int[] {0,0,1,1,1,0,0,1,1,1};
		int[] arr = new int[] {1,1,1,0,0,0,1,1,1,1,0};
		int maxSubArray =  maxSubArrayWithKflips(arr,2);
		//int maxSubArray =  maxSubArrayWithKflips(arr,2);
		System.out.println(maxSubArray);
	}

	private static int maxSubArrayWithKflips(int[] arr, int k) {
		// TODO Auto-generated method stub
		int maxFlips=Integer.MIN_VALUE;
		int tail=0,n=arr.length;
		int head=0;
		int zerocnt = 0;
		for(;head<n;head++) {
			if(arr[head] == 0) {
				zerocnt++;
			}
				if(zerocnt > k) {
					maxFlips = Math.max(maxFlips, head - tail);
					while(zerocnt > k) {
						if(arr[tail] ==  0) {
							zerocnt--;
						}
						tail++;
					}
				}
		}
		
		return Math.max(maxFlips, head - tail);
	}

}
