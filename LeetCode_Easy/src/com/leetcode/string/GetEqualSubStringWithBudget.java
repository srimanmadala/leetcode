package com.leetcode.string;

public class GetEqualSubStringWithBudget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(equalSubstring("abcd", "bcdf", 3));
		System.out.println(equalSubstring("abcd", "cdef", 3));
		System.out.println(equalSubstring("abcd", "acde", 0));
	}

	 public  static int equalSubstring(String s, String t, int maxCost) {

	        int currentCost = 0;
	        int left=0;
	        int right =0;
	        int n = s.length();
	        int maxLength = Integer.MIN_VALUE;
	        for(;right<n;right++){
	        	currentCost+=cost(s,t,right);
	        	if(currentCost > maxCost) {
	        		maxLength  = Math.max(maxLength, right-left);
	        		while(currentCost > maxCost) {
	        			currentCost-=cost(s,t,left);
	        			left++;
	        		}
	        	}
	        }

	        return Math.max(maxLength, right-left);
	        
	    }

	    public static int cost(String s, String t,int index) {
	        return Math.abs(s.charAt(index) - t.charAt(index));
	    }
}
