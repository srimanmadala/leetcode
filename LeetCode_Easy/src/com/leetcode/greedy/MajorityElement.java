package com.leetcode.greedy;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] elements = new int[] {3,2,2,4,2,2}; //2,2,2,2,3,4
		
		int timeTakenForAllMices = majorityElement(elements);
		System.out.println("timeTakenForAllMices ::: "+timeTakenForAllMices);
	}

	private static int majorityElement(int[] elements) {
		// TODO Auto-generated method stub
		int n = elements.length;
		Arrays.sort(elements);
		
		return n %2!=0 ? elements[n/2]:elements[n/2 - 1];
	}

}
