package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find leastNumber of Meetings
 * 1<=N<=10^5
 * 1 <= arr[]i[0] <= arr[i][1] <= 10^9
 * 
 */
public class LeastNumberOfMeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int meetingRooms = leastNumberOfMeetingRooms(new int[][] {{5,10},{15,20},{0,30}});
		System.out.println("meetingRooms :: "+meetingRooms);
		  //0,1  , 5 1, 10 -1  15 1  20 -1 30 -1
	}

	private static int leastNumberOfMeetingRooms(int[][] meetingTimmings) {
		// TODO Auto-generated method stub
		List<Pair<Integer,Integer>> pairs = new ArrayList<>();
		for(int i=0;i<meetingTimmings.length;i++) {
			pairs.add(new Pair<Integer,Integer>(meetingTimmings[i][0], 1));
			pairs.add(new Pair<Integer,Integer>(meetingTimmings[i][1], -1));
		}
		
		Comparator<Pair<Integer,Integer>> cmp = (a,b)->Integer.compare(a.t1,b.t1);
		List<Pair<Integer,Integer>> pairsAsc = pairs.stream().sorted(cmp)
				.collect(Collectors.toList());
		int meetingRooms = 0;
		int maxMeetingRooms = 0;
		for(int i=0;i<pairsAsc.size();i++) {
			Pair<Integer,Integer> p = pairsAsc.get(i);
			meetingRooms+=p.t2;
			maxMeetingRooms = Math.max(maxMeetingRooms, meetingRooms);
		}
		
		return maxMeetingRooms;
	}

}
