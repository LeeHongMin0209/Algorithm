package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Vector;

public class KAKAO2021_02 {
	static ArrayList<String> list = new ArrayList<>();
	static public String[] solution(String[] orders, int[] course) {
        String[] answer = {};        
        for(int j = 0; j < orders.length; j++) {
        	char[] arr = orders[j].toCharArray();
        	int n = orders[j].length();
        	boolean[] visited = new boolean[n];
        	for(int i = 0 ; i < course.length ; i++) {
        		int size = course[i];
        		combination(arr, visited, 0, n, size);	
        	}       	
        }
        ArrayList<Vector<String>> list2 = new ArrayList<>();
        for(int i = 0 ; i < course.length; i++) {
        	Vector<String> temp = new Vector<>();
        	int size = course[i];
        	for(int j = 0; j < list.size(); j++) {
        		String s = list.get(j);
        		if(s.length() == size) temp.add(s);
        	}
        	list2.add(temp);
        }
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < list2.size(); i++) {
        	Vector<String> tmp = new Vector<>();
        	tmp = MaxValue(list2.get(i));
        	for(int j = 0; j < tmp.size(); j++) {
        		set.add(tmp.get(j));
        	}
        }
        answer = new String[set.size()];
        int cnt = 0;
        for(String s : set) {
        	answer[cnt] = s;
        	cnt++;
        }
        Arrays.sort(answer);
        return answer;
    }
	
	  static void combination(char[] arr, boolean[] visited, int start, int n, int r) {
	        if (r == 0) {
	        	int cnt = 0;
	        	for (int i = 0; i < n; i++) {
	                if (visited[i]) cnt++;   
	            }
	        	char[] tmp = new char[cnt];
	        	cnt = 0;
	        	for(int i = 0; i < n; i++) {
	        		if(visited[i]) {
	        			tmp[cnt] = arr[i];
	        			cnt++;
	        		}
	        	}
	        	Arrays.sort(tmp);
	        	String s = "";
	        	for(int i = 0; i < tmp.length; i++) {
	        		s += tmp[i];
	        	}
	        	list.add(s);
	            return;
	        }

	        for (int i = start; i < n; i++) {
	            visited[i] = true;
	            combination(arr, visited, i + 1, n, r - 1);
	            visited[i] = false;
	        }
	  }
	  static Vector<String> MaxValue(Vector<String> vec){
		  int max = 2;
		  Vector<String> str = new Vector<>();
		  for(int i = 0; i <vec.size(); i++) {
			  int cnt = 1;
			  String s = vec.get(i);
			  for(int j = 0; j < vec.size(); j++) {
				  if(s.equals(vec.get(j)) && i != j) cnt++;
			  }
			  max = Math.max(max, cnt);
		  }
		  for(int i = 0; i <vec.size(); i++) {
			  int cnt = 1;
			  String s = vec.get(i);
			  for(int j = 0; j < vec.size(); j++) {
				  if(s.equals(vec.get(j)) && i != j) cnt++;
			  }
			  if(cnt == max) str.add(s);
		  }
		  return str;
	  }
	public static void main(String[] args) {
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2,3,4};
		String[] ans = solution(orders,course);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
