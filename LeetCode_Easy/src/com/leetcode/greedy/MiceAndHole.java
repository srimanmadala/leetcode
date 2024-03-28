package com.leetcode.greedy;

import java.util.Arrays;

public class MiceAndHole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] micePosition = new int[] {3,2,-4}; //-4 2 3
		int[] holePosition = new int[] {0,-2,4}; //-2 0,4
		
		int timeTakenForAllMices = miceAndHole(micePosition,holePosition);
		System.out.println("timeTakenForAllMices ::: "+timeTakenForAllMices);
	}

	private static int miceAndHole(int[] micePosition, int[] holePosition) {
		// TODO Auto-generated method stub
		Arrays.sort(micePosition);
		Arrays.sort(holePosition);
		int n = micePosition.length;
		int timeTaken = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			timeTaken=Math.max(timeTaken,Math.abs(micePosition[i] - holePosition[i]));
		}
		return timeTaken;
	}

}
