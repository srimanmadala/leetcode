package com.gfg.array;

import java.util.HashMap;
import java.util.Map;

public class PairWithGivenSumInUnsorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {3,2,8,15,-8};
		boolean present = pairWithGivenSumInUnsorted(arr,17);
		System.out.println("present ::: "+present);
		
	}

	private static boolean pairWithGivenSumInUnsorted(int[] arr, int sum) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> indexMap = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			
			if(indexMap.containsKey(sum - arr[i])) {
				System.out.println(indexMap.get(sum - arr[i])+" "+i);
				return true;
			}
			
			indexMap.put(arr[i], i);
			
		}
		return false;
	}

}
