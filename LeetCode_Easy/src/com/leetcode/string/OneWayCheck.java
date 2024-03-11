package com.leetcode.string;

public class OneWayCheck {

	public static void main(String[] args) {
		
		//System.out.println(check("pale","ple")); //true
		//System.out.println(check("pales","ple")); //false
		//System.out.println(check("pale","bale"));//true
		//System.out.println(check("pale","bake")); //false
		//System.out.println(check("palestab","pale")); //true
		//System.out.println(check("pale","pales")); //true
		
		System.out.println(check("pali","bale"));//false
		System.out.println(check("pale","bake")); //false
	}

	
	public static boolean check(String s1, String s2) {
		// TODO Auto-generated method stuble
		
		int i = 0;
		int j=0;
		int m=s1.length();
		int n=s2.length();
		
		if((int)Math.abs(m-n) > 1) {
			return false;
		}
		
		while(i < m && j < n) {
			if(s1.charAt(i) ==  s2.charAt(j)) {
				i++;
				j++;
				
			}else {
				return checkOne(s1,s2,i+1,j+1) || checkOne(s1,s2,i+1,j) || checkOne(s1,s2,i,j+1);
			}
			
		}
		
		return  s1.length() - i > 1 ||  s2.length() - j > 1 ? false : true;
	}

	private static boolean checkOne(String s1, String s2, int i, int j) {
		// TODO Auto-generated method stub
		
		while(i < s1.length() && j < s2.length()) {
			if(s1.charAt(i) !=  s2.charAt(j)) {
				return false;
			}
			i++;
			j++;
		}
		return s1.length() - i > 1 ||  s2.length() - j > 1 ? false : true;
	}

	
	
	
	
}
