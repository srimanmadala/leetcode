package com.leetcode.greedy;

public class FlipBulbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(flipBulbs(new int[] {0,1,0,1,1,0,1,1}));

	}

	/**
	 * [.,.,.,.,.b,.,.,.,.] --> cost
	 * if bild[i] == 1 continue;
	 * else increment cost and flip right hand side bits
	 * if 1 is flipped twice the resultant is the original one
	 *  ex 1-> 0->1  (one flip--0, another flip--1) 0,1,0,1,1,0,1,1
	 * @param bulbs
	 * @return cost for flippling to bright blubs
	 */
	private static int flipBulbs(int[] bulbs) {
		// TODO Auto-generated method stub
		int cost=0;
		for(int i=0;i<bulbs.length;i++) {
			
			if(cost % 2 == 0) { // even cost flips nullify to original one
				bulbs[i] = bulbs[i];
			}else {
				bulbs[i] = bulbs[i] == 1 ? 0 : 1;
			}
			
			
			if(bulbs[i] == 1) {
				continue;
			}else {
				cost = cost+1;
			}
		}
		
		return cost;
	}

}
