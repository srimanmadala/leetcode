package com.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array A of size N consisting of unique integers from 1 to N. 
 * You can swap any two integers atmost B times.
 * Return the largest lexicographical value array that can be created by executing atmost
 *  B swaps.
 * 
 * 1 <= N <= 106
 * 1 <= B <= 109
 */
public class LargestPermutation {

	/**
	 * 1<=arr[i]<=N
	 *  A = [1, 2, 3, 4] 
	 *  B = 1
	 *  output - [4, 2, 3, 1]
	 *  
	 *  A = [3, 2, 1]
	 *  B = 2
	 *  output - [3, 2, 1]
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = largestPermutation(new int[] {1, 2, 3, 4},1);
		//int[] arr = largestPermutation(new int[] {3, 2, 1},2);
		//int[] arr = largestPermutation(new int[] {1,2,3},2); // 3 2 1
		for(int j=0;j<arr.length;j++) {
			System.out.print(arr[j]+" ");
		}

	}

	private static int[] largestPermutation(int[] arr, int k) {
		
		Map<Integer,Integer> indxMap = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			indxMap.put(arr[i], i);
		}
		
		int max = arr.length;
		int cnt=0;
		for(int j=0;j<arr.length;j++) {
			int index = indxMap.get(max);
			if(index == j) {
				max = max-1;
				continue;
			}
			indxMap.put(arr[index], j);
			indxMap.put(arr[j], index);
			int tmp = arr[index];
			arr[index] = arr[j];
			arr[j] = tmp;
			cnt++;
			if(cnt == k)
				break;
			max = max-1;
		}
		return arr;
	}

}
