package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1931 {
	
	static class meeting{
		int start;
		int end;
		public meeting(int strat, int end) {
			this.start = strat;
			this.end = end;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<meeting> list = new ArrayList<BOJ1931.meeting>();
		int[] room = new int[100000];
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int strat = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new meeting(strat, end));
		}
		
		Collections.sort(list, new Comparator<meeting>() {

			@Override
			public int compare(meeting m1, meeting m2) {
				if(m1.end < m2.end) {
					return -1;
				}
				else if(m1.end > m2.end) {
					return 1;
				}
				else if(m1.end == m2.end) {
					if(m1.start < m2.start) {
						return -1;
					}
					else if(m1.start > m2.start) {
						return 1;
					}
				}
				return 0;
			}	
		});
		
		int cnt = 0;
		int curTime = 0;
		for(int i = 0; i < n; i++) {
			if(curTime > list.get(i).start) continue;
			cnt++;
			curTime = list.get(i).end;
		}
		System.out.println(cnt);
	}

}
