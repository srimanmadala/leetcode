package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LongestPrfixSuffix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//abab -- aaaa -- 3
		System.out.println(lps("abab"));
		
		
		System.out.println(lps("aaaa"));
	}

	private static int lps(String s) {
		// TODO Auto-generated method stubt
		int n = s.length();
		if(n == 0 || n == 1) {
			return n;
		}
		
		Set<String> result = new HashSet<>();
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			String newStr = s.substring(0, i);
			result.add(newStr);
		}
		
		
		for(int j=n-1;j>=0;j--) {
			String newStr = s.substring(j, n);
			if(result.add(newStr) == false) {
				if(max < n-j) {
					max = n-j;
					System.out.println(s.substring(j, n));
				}
			}
		}
		return max;
	}

}
