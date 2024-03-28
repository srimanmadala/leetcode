package com.leetcode.dp;

import java.util.HashMap;
import java.util.List;

public class MinCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println(minChange(8, List.of(1, 5, 4, 12)));
		System.out.println(System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		System.out.println(minChange(8, List.of(1, 5, 4, 12), new HashMap<>()));
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static int minChange(int amount, List<Integer> coins) {
		
		if(amount == 0) {
			return 0;
		}
		
		if(amount < 0) {
			return -1;
		}
        
		int minCoins = -1;
		for(Integer coin : coins) {
			int subAmt = amount - coin;
			int subcoins = minChange(subAmt,coins);
			if(subcoins != -1) {
				int numCoins = subcoins + 1;
				if(numCoins <  minCoins || minCoins==-1)
				minCoins = numCoins;
			}
		}
	    return minCoins;
	  }
	
	
	
public static int minChange(int amount, List<Integer> coins,HashMap<Integer,Integer> memo) {
		
		if(amount == 0) {
			return 0;
		}
		
		if(amount < 0) {
			return -1;
		}
		if(memo.containsKey(amount)) {
			return memo.get(amount);
		}
        
		int minCoins = -1;
		for(Integer coin : coins) {
			int subAmt = amount - coin;
			int subcoins = minChange(subAmt,coins);
			if(subcoins != -1) {
				int numCoins = subcoins + 1;
				if(numCoins <  minCoins || minCoins==-1)
				minCoins = numCoins;
			}
		}
		memo.put(amount, minCoins);
	    return minCoins;
	  }
	
	

}
