package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class DisJointIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int intervals = disJointIntervals(new int[][]{{1,2},{2,10},{4,6}});
		System.out.println(intervals);
		//int product1 = disJointIntervals(new int[][] {{1,4},{2,3},{4,6},{8,9}});
		//System.out.println(product1);
	}

	
	/**
	 * The interval which ends early will give us more scope for taking other interval 
	 * The interval starts later or big interval can intersect with other intervals.
	 * 
	 * @param arr
	 * @return number of disjoint intervals.
	 */
	private static int disJointIntervals(int[][] arr) {
		
		//Sort arrays by ending time i.e, arr[0][1](say)
		Comparator<int[]> cmp = (a,b)-> Integer.compare(a[1], b[1]);
		Arrays.sort(arr,cmp);
		for(int i=0;i<arr.length;i++)
		System.out.println(Arrays.toString(arr[i]));
		
		int prev_start = arr[0][0],prev_end = arr[0][1];
		int interval_count =1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i][0] > prev_end) {
				interval_count = interval_count + 1;
				prev_start = arr[i][0];
				prev_end = arr[i][1];
			}
		}
		
		return interval_count;
	}

}
