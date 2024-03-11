package com.leetcode.string;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(removeAllAdjacentDuplicatesII("abcd",  3));
		//System.out.println(removeAllAdjacentDuplicatesII("deeedbbcccbdaa",  3));
		System.out.println(removeAllAdjacentDuplicatesII("pbbcggttciiippooaais",  2));
	}

	
	//Recursive Solution 
	//TC:O(N) SC:O(N)
	 public  static String removeAllAdjacentDuplicatesII(String s,  int k) {

	       int n = s.length();
	       int count =  1;
	        for(int i=1;i<n;i++){
	        	if(s.charAt(i) == s.charAt(i-1)) {
	        		count++;
	        	}else {
	        		count = 1;
	        	}
	        	
	        	if(count == k) {
	        		
	        		String newStr = s.substring(0, i-k+1)+s.substring(i+1);
	        		System.out.println("newStr:: "+newStr);
	        		return removeAllAdjacentDuplicatesII(newStr,k);
	        	}
	        }

	        return s;	        
	    }
	 
	 
	 
		//TC:O(N) SC:O(N)
		 public  static String removeAllAdjacentDuplicatesStack(String s,  int k) {

			 Stack<int[]> main = new Stack<>();
		       int n = s.length();
		        for(int i=1;i<n;i++){
		        	char c = s.charAt(i);
		        	if(!main.isEmpty() && main.peek()[0] == c ) {
		        		 main.peek()[1]++;
		        	}else {
		        		main.push(new int[] {c,1});
		        	}
		        	StringBuilder sb = new StringBuilder();
		        	if(main.peek()[1] == k) {
		        		int[] val = main.pop();
		        		/*String newStr = s.substring(0, i-k+1)+s.substring(i+1);
		        		System.out.println("newStr:: "+newStr);
		        		return removeAllAdjacentDuplicatesII(newStr,k);*/
		        	}
		        }

		        return s;	        
		    }

}
