package com.leetcode.string;

public class LongestPalindromeSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Naive Approach start
		 */
		//generateSubString("ABCD");
		generateSubString("aaaabbaa"); 
		
		//generateSubString("abc");
		//Naviive approach end
		

	}

	private static void generateSubString(String s) {
		// TODO Auto-generated method stub
		int len = 1;
		int n = s.length();
		int start =0;
		int end =0;
		int maxLen = Integer.MIN_VALUE;
		int count=0;
		while(len <= n) {
			for(int i=0;i<=n-len;i++) {
				String palcheck = s.substring(i, i+len);
				System.out.println(palcheck);
				++count;
				if(isPalindrome(palcheck) && maxLen < len) {
					start = i;
					end = i+len;
					maxLen = len;
				}
			}
			len++;
		}
		System.out.println();
		System.out.println();
		System.out.println("LargePalindorme SubString..."+s.substring(start, end));
		System.out.println("NumberOfSubStrings "+count);
		
	}
	
	public static boolean isPalindrome(String s) {
		
		if(s.length() == 0 || s.length() == 1) {
			return true;
		}
		
		if(s.charAt(0) != s.charAt(s.length() - 1)) {
			return false;
		}
		return isPalindrome(s.substring(1, s.length() - 1));
	}

}
