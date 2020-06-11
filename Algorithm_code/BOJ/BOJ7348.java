package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ7348 {
	
	static class room{
		int start;
		int end;
		public room(int start, int end) {
			if(start < end) {
				this.start = start;
				this.end = end;
			}
			else {
				this.start = end;
				this.end = start;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<room> list = new ArrayList<BOJ7348.room>();
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = (Integer.parseInt(st.nextToken())-1)/2;
				int end = (Integer.parseInt(st.nextToken())-1)/2;
				list.add(new room(start, end));
			}
			
			Collections.sort(list, new Comparator<room>() {

				@Override
				public int compare(room r1, room r2) {
					if(r1.start < r2.start) return -1;
					else if(r1.start > r2.start) return 1;
					return 0;
				}
			});
			int ans = 0;

			while(!list.isEmpty()) {
				int compare = Integer.MIN_VALUE;
				ans += 10;
				List<room> temp = new ArrayList<>();
				for(int j= 0; j < list.size(); j++) {
					if(list.get(j).start > compare) {
						compare = list.get(j).end; 
					}
					else temp.add(list.get(j));
				}
				list = temp;
			}
			System.out.println(ans);
		}

	}

}
