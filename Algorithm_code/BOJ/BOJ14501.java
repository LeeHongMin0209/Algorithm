package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14501 {
	static int n,t,p;
	static ArrayList<work> list;
	static boolean[] vistied;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		
		n = Integer.parseInt(br.readLine());
		vistied = new boolean[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			work w = new work(t, p);
			list.add(w);
		}
		dfs(1,0);
		
		System.out.println(max);
	}
	static void dfs(int day, int money) {	
		if(day == n+1) {
			if(max < money) max = money;		
			return;
		}
		
		if(day + list.get(day-1).T - 1 <= n) {
			dfs(day + list.get(day-1).T, money + list.get(day-1).P);
		}
		dfs(day+1 , money);
	}
	
	static class work{
		int T;
		int P;
		public work(int T, int P) {
			this.T = T;
			this.P = P;
		}
	}
}
