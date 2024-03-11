package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> result = new ArrayList<>();
		String s = "ABCD";
		List<String> results = find_permutation(s.toCharArray(),0,result);
		for(String resulti : results) {
			System.out.println(resulti);
		}
		

	}
	
	public static List<String> find_permutation(char[] S,int index,List<String> result) {
        // Code here
		if(index == S.length) {
			result.add(String.valueOf(S));
			return result;
		}
		for(int i=index;i<S.length;i++) {
			
			swap(S,i,index);
			find_permutation(S,index+1,result);
			swap(S,i,index);
			
		}
		return result;
		
    }

	private static void swap(char[] s, int i, int index) {
		// TODO Auto-generated method stub
		char tmp = s[index];
		s[index] = s[i];
		s[i] = tmp;
		
		
	}

}
