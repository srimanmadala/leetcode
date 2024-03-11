package com.leetcode.string;

public class RecursivelyRemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // removeDuplicates("geeksforgeeks",0);
         //String withoutduplicates = removeConsecutiveDuplicates("geeksforgeeks");
		//String withoutduplicates = removeConsecutiveDuplicates("bbbbbbb");
		String withoutduplicates = removeConsecutiveDuplicates("aabbbbacccdddcc");
         //String withoutduplicates = removeConsecutiveDuplicates("abbcc");
        /* String withoutduplicates = removeDuplicates1("maam");
         System.out.println(withoutduplicates);*/
         
        // String removedDuplicates =removeUtil("gge");
         
         System.out.println(withoutduplicates);
	}
	
	public static String removeConsecutiveDuplicatesRec(String s) {
		 
		 System.out.println("Start....."+s);
		 if(s.length() ==0 || s.length() == 1) {
			 return s;
		 }
	       
		 int i=0;
		 int j=1;
		 int n = s.length();
		 StringBuffer sb = new StringBuffer("");
		 while(j<n) {
			 if(s.charAt(i) == s.charAt(j)) {
				 while(j<n && s.charAt(i) == s.charAt(j)) {
					 ++j;
				 }
			 }else {
				 sb.append(s.charAt(i));
			 }
			 i=j;
			 j=j+1;
		 }
		 
		 //sb.append(s.charAt(j-1));
		 if(j>s.length()) {
			 return removeConsecutiveDuplicatesRec(sb.toString());
		 }
			 return removeConsecutiveDuplicatesRec(sb.append(s.charAt(j-1)).toString());
		 
	    }
	
	 public static String removeConsecutiveDuplicates(String s) {
		 
		 System.out.println("Start....."+s);
		 if(s.length() ==0 || s.length() == 1) {
			 return s;
		 }
	       
		 int i=0;
		 int j=1;
		 int n = s.length();
		 StringBuffer sb = new StringBuffer("");
		 while(j<n) {
			 if(s.charAt(i) == s.charAt(j)) {
				 while(j<n && s.charAt(i) == s.charAt(j)) {
					 ++j;
				 }
			 }else {
				 sb.append(s.charAt(i));
			 }
			 i=j;
			 j=j+1;
		 }
		 
		 //sb.append(s.charAt(j-1));
		 return j>s.length() ? sb.toString() : sb.append(s.charAt(j-1)).toString();
		 
	    }

	private static String removeDuplicates(String s) {
		// TODO Auto-generated method stub
		String s1="geeksforgeeks"; 
		
		int i=0;
		int j=0;
		
		StringBuffer newString = new StringBuffer();
		
		while(j < s.length()) {
			if(s.charAt(i) == s.charAt(j)) {
				j++;
			}else {
				newString.append(String.valueOf(s.charAt(i)));
				i = j;
				j++;
			}
		}
		newString.append(s.charAt(j-1));
		return newString.toString();
	}
	
	

	
}
