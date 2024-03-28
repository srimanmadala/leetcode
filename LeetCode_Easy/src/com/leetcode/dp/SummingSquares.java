package com.leetcode.dp;

import java.util.HashMap;

/**
 * 10 - 4 + 1 + 1 (3 coins)
 *     2*2 + 1*1 + 1*1
 *     9 + 1 = 3*3 + 1*1 (2 coins)
 */
public class SummingSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		summingSquares(12) -> 3
//		Source.summingSquares(8); // -> 2
//		Source.summingSquares(9); // -> 1
//		Source.summingSquares(12); // -> 3
//		Source.summingSquares(31); // -> 4
//		Source.summingSquares(87); // -> 4
//		Source.summingSquares(68); // -> 2
//		Source.summingSquares(50); // -> 2
		int a = 87;
		System.out.println(summingSquares(a));
		//System.out.println(summingSquares(a, new HashMap<>()));
	}
	
	private static int summingSquares(int a) {
		
		if(a == 0) {
			return 0;
		}
		
		int minCoins = Integer.MAX_VALUE;
		for(int i=1;i*i<=a;i++) {
			int coins = 1+summingSquares(a-i*i);
			
			if(coins  <  minCoins ) {
				minCoins = coins ;
			}
		}
		return minCoins;
	}
	
	
private static int summingSquares(int a,HashMap<Integer,Integer> memo) {
		
		if(a == 0) {
			return 0;
		}
		
		if(memo.containsKey(a)) {
			return memo.get(a);
		}
		
		int minCoins = Integer.MAX_VALUE;
		for(int i=1;i*i<=a;i++) {
			int coins = 1+summingSquares(a-i*i,memo);
			
			if(coins  <  minCoins ) {
				minCoins = coins ;
			}
		}
		memo.put(a, minCoins);
		return minCoins;
	}

}
