package com.leetcode.array;

public class SortedRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] arr = new int[] {5,6,7,0,1,2};
		int[] arr = new int[] {6,7,0,1,2,3,4,5};		
		System.out.println(findElementInSortedRotated(arr, 7));
		System.out.println(findElementInSortedRotated(arr, 5));

	}

	private static int findElementInSortedRotated(int[] arr,int target) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(arr[mid] == target)
				return mid;
			if(arr[low] < arr[mid]) {
				
				if(arr[low] <= target &&  arr[mid] >= target) {
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}else {
				if(arr[mid] <= target &&  arr[high] >= target) {
					low = mid + 1;
				}else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

}
