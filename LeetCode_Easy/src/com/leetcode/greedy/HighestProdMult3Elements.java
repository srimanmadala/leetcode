package com.leetcode.greedy;

import java.util.Arrays;

public class HighestProdMult3Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int product = highestProdMult3Elements(new int[] {-5,-2,-1,0,0,3,4,5});
		System.out.println(product);
		int product1 = highestProdMult3Elements(new int[] {-5,-2,-1,0,0,1,1,5});
		System.out.println(product1);
	}

	private static int highestProdMult3Elements(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		Arrays.sort(arr);
		int highest3 = arr[n-1] * arr[n-2] * arr[n-3];
		int low2High1 = arr[0] * arr[1] * arr[n-1];
		return Math.max(highest3, low2High1);
	}

}
