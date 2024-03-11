package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Integer> allAnagrams = findAllAnagrams("cbaebabacd","abc");
		
		//List<Integer> allAnagrams = findAnagrams("cbaebabacd","abc");
		//List<Integer> allAnagrams = findAllAnagrams("abab","ab");
		List<Integer> allAnagrams = findAllAnagrams("aa","bb");
		for(Integer val : allAnagrams)
		System.out.print(val+" ");

	}

	private static List<Integer> findAllAnagrams(String s, String patern) {
		// TODO Auto-generated method stub
		int[] paternArr = new int[26];
		int[] sArr = new int[26];
		int pLen = patern.length();
		int sLen= s.length();
		
		List<Integer> result = new ArrayList<>();
		if(pLen > sLen) {
			return result;
		}
		
		for(int i=0;i<pLen;i++) {
			paternArr[patern.charAt(i) - 'a']++;
		}
		
		int start = 0;
		for(int i=0;i<sLen;i++) {
			sArr[s.charAt(i) - 'a']++;
			
			if(i-start+1 > pLen) {
				sArr[s.charAt(start) - 'a']--;
				start++;
			}
			
			if(i-start+1 == pLen && isAnagram(sArr,paternArr)) {
				result.add(i-pLen+1);
			}
		}
		
		
		return result;
	}
	
	
	private static boolean isAnagram(int[] sArr, int[] paternArr) {
		// TODO Auto-generated method stub
		for(int i=0;i<sArr.length;i++) {
			if(sArr[i] != paternArr[i]) {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length())
            return Collections.emptyList();
        Map<Character, Integer> sCount = new HashMap<>(), pCount = new HashMap<>();
        for(char c : p.toCharArray()) {
            pCount.merge(c, 1, Integer::sum);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            sCount.merge(s.charAt(i), 1, Integer::sum);
            if(i >= p.length()) {
                char leftMost = s.charAt(i-p.length());
                int leftMostCount = sCount.get(leftMost);
                if(leftMostCount == 1) {
                    sCount.remove(leftMost);
                } else {
                    sCount.put(leftMost,leftMostCount-1);
                }
            }
            if(pCount.equals(sCount)) {
                result.add(i-p.length()+1);
            }
        }
        return result;
    }

}
