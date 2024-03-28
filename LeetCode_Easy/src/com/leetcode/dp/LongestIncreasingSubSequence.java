package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence {

	public static List<Integer> track = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println( longestIncreasingSubSequence(new int[] {3,4,2,8,10},0,new ArrayList<>()));
		System.out.println( longestIncreasingSubSequence(new int[] {4,10,6,5,8,11,2,20},0));
		System.out.println( longestIncreasingSubSequence(new int[] {4,10,6,5,8,11,2,20},0,-1));
	}

	private static int longestIncreasingSubSequence(int[] arr,int index) {
		// TODO Auto-generated method stub
		
		if(index == arr.length) {
			return 0;
		}
		
		int excl = 0+longestIncreasingSubSequence( arr, index+1);
		int incl = 0;
		if(track.size() == 0 || arr[index] > track.get(track.size()-1) ) {
			track.add(arr[index]);
			incl= 1+longestIncreasingSubSequence( arr, index+1);
		}
		return Math.max(incl,excl);
	}
	
	
	private static int longestIncreasingSubSequence(int[] arr,int i,int prev) {
	// Base case: if nothing is remaining
	if (i == arr.length)
		return 0;

	// case 1: exclude the current element and process the
	// remaining elements
	int exclude = longestIncreasingSubSequence(arr, i + 1,  prev);

	// case 2: include the current element if it is greater
	// than previous element in LIS
	int include = 0;
	if (arr[i] > prev)
		include = 1 + longestIncreasingSubSequence(arr, i + 1,  arr[i]);

	// return maximum of above two choices
	return Math.max(include, exclude);
}
	
	

}
