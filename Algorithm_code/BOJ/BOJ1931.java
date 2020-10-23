package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ1931{
	static class dot implements Comparable<dot>{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(dot d) {
			if(d.y == this.y) return this.x - d.x;
			else return this.y - d.y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		Vector<dot> vec = new Vector<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			vec.add(new dot(x, y));
		}
		Collections.sort(vec);
		int start = 0;
		int end = 0;
		for(int i = 0; i < n; i++) {
			if(vec.get(i).x >= end) {
				ans++;
				end = vec.get(i).y;
			}
		}
		System.out.println(ans);
	}

}
