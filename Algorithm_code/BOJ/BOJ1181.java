package BOJ;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

public class BOJ1181 {
	static String[] str = new String[200002];
	static int[] arr = new int[51];
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			str[i] = s;
			int len = s.length();
			map.put(s, len);
		}
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름 차순 정렬
				if(obj1.getValue() != obj2.getValue()) return obj1.getValue().compareTo(obj2.getValue());
				else return obj1.getKey().compareTo(obj2.getKey());
			}
		});
		for(Entry<String, Integer> entry : list_entries) {
			System.out.println(entry.getKey());
		}		
	}

}
