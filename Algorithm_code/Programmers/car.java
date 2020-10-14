package Programmers;

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class car {
	static class vote implements Comparable<vote> {
		String name;
		int num;
		public vote(String name, int num) {
			this.name = name;
			this.num = num;
		}
		@Override
		public int compareTo(vote v) {
			if(v.num != this.num) return v.num - this.num;
			else return this.name.compareTo(v.name);
		}
		
	}
	static public String solution(String[] votes, int k) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		for(String str : votes) {
			if(map.containsKey(str)) {
				map.replace(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}
		vote[] v = new vote[map.size()];
		int i = 0;
		for(java.util.Map.Entry<String, Integer> elem : map.entrySet()){
			String key = elem.getKey();
			int val = elem.getValue();
            v[i] = new vote(key, val);
            i++;
        }
        Arrays.sort(v);
        int max = 0;
        for(int j = 0; j < k; j++) {
        	max += v[j].num;
        }
        int tmp = 0;
        for(int j = v.length - 1; j >= 0; j--) {
        	tmp += v[j].num;
        	if(tmp >= max) {
        		answer = v[j+1].name;
        		break;
        	}
        }
		return answer;
	}
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		String[] votes = {"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"};
		for(String str : votes) {

			if(map.containsKey(str)) {
				map.replace(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}
		vote[] v = new vote[map.size()];
		int i = 0;
		for(java.util.Map.Entry<String, Integer> elem : map.entrySet()){
			String key = elem.getKey();
			int val = elem.getValue();
            v[i] = new vote(key, val);
            i++;
        }
        Arrays.sort(v);
        for(int i1 = 0; i1 < v.length; i1++) {
        }
        String answer = solution(votes, 2);
        System.out.println(answer);
	}
}
