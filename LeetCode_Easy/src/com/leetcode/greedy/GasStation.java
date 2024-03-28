package com.leetcode.greedy;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = new int[] {3,5,2,1,7}; 
		int[] cost = new int[] {4,2,1,9,1};
		//int[] newGas = new int[] {3,5,2,1,7,3,5,2,1,7}; 
		//int[] cost = new int[] {4,2,1,9,1};
		//int[] newCost = new int[] {4,2,1,9,1,4,2,1,9,1};
		
		//3,5,2,1,7, 3,5,2,1,7
		//4,2,1,9,1, 4,2,1,9,1
	          //6  5 8 9 1 
		
		
		
		//1, 2, 3,4,5  1,2,3,4,5
		//3, 4, 5,1,2  3,4,5,1,2
		//-2 -2 -2 3 6  4 2 0 
		int[] newGas = new int[] {1,2,3,4,5,1,2,3,4,5}; 
		int[] newCost = new int[] {3, 4, 5,1,2,3, 4, 5,1,2};
		/*
		 * int statrtIndexForCircular = canCompleteCircle(newGas,newCost,gas.length);
		 * System.out.println(statrtIndexForCircular);
		 */
		System.out.println(canCompleteCircle(newGas,newCost,gas.length));
		System.out.println(canCompleteCircuitFromINdex(gas,cost,gas.length));
		/*
		 * int timeTakenForAllMices = canCompleteCircuite(elements);
		 * System.out.println("timeTakenForAllMices ::: "+timeTakenForAllMices);
		 */
	}

	private static int canCompleteCircle(int[] gas,int[] cost,int n) {
		int curent_cost = 0;
		int startIndex =0;//Assume circular has started at 0th index
		
		for(int i=0;i<gas.length;i++) {
			
			if(i==startIndex+n){
				return startIndex;
			}
			curent_cost = curent_cost+(gas[i]-cost[i]);
			if(curent_cost < 0) {
				curent_cost = 0; //could not complete circle as there is no sufficient gas 
				                //to reach  next destination..
				startIndex = i+1;
			}
			
		}
		return -1;
	}
	
	
	public static int canCompleteCircuitFromINdex(int[] gas, int[] cost,int n) {

        int curent_cost = 0;
		int startIndex =-1;
		int i=0;
		while(i<2*n) {
			
			if(i%n == startIndex){
				return startIndex;
			}
			curent_cost = curent_cost+(gas[i%n]-cost[i%n]);
			if(curent_cost < 0) {
				curent_cost = 0;
				startIndex = (i+1) % n;
			}
			i++;
        }
        return -1;
        }

}
