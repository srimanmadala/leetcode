package com.leetcode.string;

public class LongestRepeatingCharReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(longestRepeatingCharReplacement("AABABBA",2));
		//System.out.println(characterReplacement("AABABBA",2));
		System.out.println(characterReplacement("AABABBA",1));
		//System.out.println(longestRepeatingCharReplacement("AABABBA",1));

	}

	private static int longestRepeatingCharReplacement(String s, int k) {
		// TODO Auto-generated method stub
		int n = s.length();
        int start =0;
        int cnt =0,max_sub_string=Integer.MIN_VALUE;
        int end=1;
        for(;end<n;end++) {
            if(s.charAt(end) != s.charAt(start)) {
                cnt++;
            }
            if(cnt > k) {
                max_sub_string = Math.max(max_sub_string,end - start);
                while(cnt > k) {
                    if(s.charAt(end) != s.charAt(start)) {
                        cnt--;
                    }
                    start++;
                }
            }
        }
        return  Math.max(max_sub_string,end - start);
	}
	
	
	
	 public static int characterReplacement(String s, int k) {
	        // Initialising an empty array to store the count of the 
	        // characters in the given string s
	        int[] arr = new int[26];
	        int res = 0;
	        int max = 0;

	        // The left pointer for the sliding window is l AND r is the 
	        // right pointer
	        int l = 0;
	        for (int r = 0; r < s.length(); r++) {
	            // Counting the number of each character in the string s
	            arr[s.charAt(r) - 'A']++;

	            // Checking the character with max number of occurrence
	            max = Math.max(max, arr[s.charAt(r) - 'A']);

	            // Now we check if our current window is valid or not
	            if (r - l + 1 - max > k) { 
	            // this means the no. of replacements is more than
	            // allowed (k)
	                // Decrementing the count of the character which was 
	                // at l because it is no longer in the window
	                arr[s.charAt(l) - 'A']--;
	                l++;
	            }

	            // The max our window can be
	            res = Math.max(res, r - l + 1);
	        }

	        return res;
	    }

}
