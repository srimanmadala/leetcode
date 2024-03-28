package com.leetcode.dp;

import java.util.HashMap;
import java.util.List;

/**
 * amount = 4
 * [1 2 3]
 * 1+1+1+1 = 4 
 * 1+2+1 = 4
 * 2+2=4
 * 3+1
 * 
 * total 4 ways.
 * if we go with  our regular approach we get 7 ways
 * includes ( 1+1+2  1+3,  2+2 - extra 3 ways added  to 4  4+3=7 ways)
 * 
 * 
 * To avoid we go by each coin in the recursion tree
 */
public class CountingChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 8;//4;
		//System.out.println(countingChange(a,0,new int[] {1,2,3}));
		System.out.println(countingChange(a,0,new int[] {1,2,3}));
		System.out.println(countingChange(24,0,new int[] {5,7,3}));
		System.out.println(countingChange(10,0,new int[] {2,5,3,6}));
		//System.out.println(summingSquares(a, new HashMap<>()));
	}
	

	
	private static int countingChange(int a,int index,int arr[]) {
		
		if(a == 0) {
			return 1;
		}
		
		if(index >= arr.length) {
			return 0;
		}
		
		int totalWays = 0;
		int amount = arr[index];
		for(int quantity=0;quantity*amount<=a;quantity++) {
			int subAmount = a -  quantity*amount;
			totalWays+=countingChange(subAmount,index+1,arr);
			}
		return totalWays;
	}
	
	
private static int countingChange(int a,int index,int arr[],HashMap<List<Integer>,Integer> memo) {
		
		if(a == 0) {
			return 1;
		}
		
		if(index >= arr.length) {
			return 0;
		}
		
		List<Integer> key = List.of(index,a);
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int totalWays = 0;
		int amount = arr[index];
		for(int quantity=0;quantity*amount<=a;quantity++) {
			int subAmount = a -  quantity*amount;
			totalWays+=countingChange(subAmount,index+1,arr,memo);
			}
		memo.put(key, totalWays);
		return totalWays;
	}

}
