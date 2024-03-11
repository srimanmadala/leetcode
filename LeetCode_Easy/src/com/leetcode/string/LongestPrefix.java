package com.leetcode.string;

public class LongestPrefix {
	
	public static void main(String[] args) {
		String prefix = longestCommonPrefix(new String[] 
				{"geeksforgeeks", "geeks", "geek", "geezer"},4);
		System.out.println(prefix);
	}

	
	public static String longestCommonPrefix(String arr[], int n) {
		// code here
		if (n == 1)
			return arr[0];

		String base = arr[0];
		int len = base.length();
		int j = 0;
		for (; j < len; j++) {
			boolean nomatch=false;
			for (int i = 1; i < n; i++) {
				String curent = arr[i];
				if (j >= curent.length() || base.charAt(j) != curent.charAt(j)) {
					nomatch=true;
				}

			}
			if(nomatch)
				break;
		}
		return base.substring(0, j);

	}
}
