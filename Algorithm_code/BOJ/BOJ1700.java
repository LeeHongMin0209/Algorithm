package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1700 {
	static int n,m,ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < m; i++) {
			if(list.size() < n) {
				if(list.contains(arr[i])) continue;
				list.add(arr[i]);
			}
			else {
				if(list.contains(arr[i])) continue;
				int target = arr[i];
				HashSet<Integer> tmp = new HashSet<>();
				for(int j = i; j < m; j++) {
					if(tmp.size() < list.size() - 1) {
						if(list.contains(arr[j])) {
							tmp.add(arr[j]);
						}
					} else break;
				}
				if(tmp.size() > 0) {
					int idx = 0;
					for(int j =0; j < list.size(); j++) {
						if(!tmp.contains(list.get(j))) {
							idx = j;
							break;
						}
					}
					list.set(idx, target);
				} else {
					list.set(0, target);
				}
				ans++;
			}
		}
		System.out.println(ans);
	}

}
