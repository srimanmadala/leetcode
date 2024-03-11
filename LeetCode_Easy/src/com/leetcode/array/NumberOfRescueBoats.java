package com.leetcode.array;

import java.util.Arrays;

public class NumberOfRescueBoats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] weightofpersons = new int[] { 11, 2, 9, 1, 12, 1, 10, 3 };
		//12,11,10,9,3,2,1
		//int rescuboats = numberOfRescueBoats(weightofpersons, 12);
		int rescuboats = numberOfRescueBoatsOptimized(weightofpersons, 12);
		System.out.println(rescuboats);
	}

	// BruteForce
	//TC:O(n^2)   SCO(n)
	private static int numberOfRescueBoats(int[] weightofpersons, int limit) {
		// TODO Auto-generated method stub
		int n = weightofpersons.length;
		boolean[] inboat = new boolean[n];
		int noOfBoats = 0;
		for (int i = 0; i < n; i++) {
			if (inboat[i]) {
				continue;
			}
			int remaingWeightInBoat = limit - weightofpersons[i];
			inboat[i] = true;
			noOfBoats++;
			if (remaingWeightInBoat != 0) {
				int j = 0;
				for (; j < n; j++) {
					if (inboat[j]) {
						continue;
					}
					if (weightofpersons[j] == remaingWeightInBoat) {
						break;
					}
				}
				if (j < n) {
					inboat[j] = true;

				}

			}
			
		}
		return noOfBoats;
	}
	
	
	// Optimal Solution
	//TC:O(nlogn) + O(n) = O(nlogn)    SC:(1)
	private static int numberOfRescueBoatsOptimized(int[] weightofpersons, int limit) {
		// TODO Auto-generated method stub
		int n = weightofpersons.length;
		int noOfBoats = 0;
		Arrays.sort(weightofpersons);
		int left = 0;
		int right = n-1;
		while(left <= right) {
			if(weightofpersons[left] + weightofpersons[right] <= limit) {
				left++;
			}
			right--;
			noOfBoats++;
		}
		return noOfBoats;
	}

}
