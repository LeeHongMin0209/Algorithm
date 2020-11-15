package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class jewelry {
	static Queue<String> qu = new LinkedList<String>();
    static HashSet<String> set = new HashSet<String>(); 
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static int startPoint = 0;
    static int length = Integer.MAX_VALUE;
	public int[] solution(String[] gems) {
		int[] answer = {};
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < gems.length; i++) {
			set.add(gems[i]);
		}
		int start = 0;
		for(int i = 0; i < gems.length; i++) {
			if(!map.containsKey(gems[i])) map.put(gems[i], 1);
			else map.put(gems[i], map.get(gems[i]) + 1);
			qu.add(gems[i]);
			while(true) {
				String temp = qu.peek();
				if(map.get(temp) > 1) {
					map.put(temp, map.get(temp) - 1);
					qu.poll();
					startPoint++;
				}
				else break;
			}
			if(map.size() == set.size() && length > qu.size()) {
				length = qu.size();
				start = startPoint;
			}
		}
		
		return new int[]{start + 1, start + length};  
	}
}
