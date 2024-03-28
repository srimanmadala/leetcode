package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A[......,i,.....] A[i-1]<A[i]<A[i+1] A[i] = max(A[i-1]+1 , A[i+1]+1)
 * 
 * default is atleast one candy [1,2,7,4,3,3,1] [1,7,4,3,1] - Lcount,RCount
 */
public class DistributeCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int totalCandies = distributeCandy(new int[] { 1, 7, 4, 3, 1 });
		// int totalCandies = distributeCandy(new int[] {1,2,7,4,3,3,1});
		System.out.println("TotalCandies...."+totalCandies);
	}

	/**
	 * We move from least value kids to most valued kids to find the no.of. candies
	 * i.e, we need to sort based on value(value,index(i) say)
	 * As we have to check their neighbours we need to know their index after sort aswell.
	 * @param studentValues
	 * @return totalCandies
	 */
	private static int distributeCandy(int[] studentValues) {
		// TODO Auto-generated method stub
		int n=studentValues.length;
		List<Pair<Integer,Integer>> pairs = new ArrayList<>();
		for(int i=0;i<n;i++) {
			pairs.add(new Pair<Integer,Integer>(studentValues[i],i));
		}
		
		Comparator<Pair<Integer,Integer>> cmp = (a,b)->Integer.compare(a.t1,b.t1);
		List<Pair<Integer,Integer>> studentFromLeastToBest =  
				pairs.stream().sorted(cmp).collect(Collectors.toList());
		
		//default one candy to each student so one-one candy is distributed to all students
		int[] candies = new int[n];
		Arrays.fill(candies, 1);
		int sum = n;
		
		for(int i=0;i<n;i++) {
			Pair<Integer,Integer> student = studentFromLeastToBest.get(i);
			int index = student.t2;
			if(index >0 && studentValues[index] > studentValues[index-1]) {
				candies[index] = Math.max(candies[index],candies[index-1] + 1);
			}
			
			if(index < n-1 && studentValues[index] > studentValues[index+1]) {
				candies[index] = Math.max(candies[index],candies[index+1] + 1);
			}
			sum+=candies[index];
		}
		
		
		return sum;
	}

}
