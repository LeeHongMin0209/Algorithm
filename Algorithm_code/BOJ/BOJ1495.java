package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1495 {
	static int n,s,m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] v = new int[n];
		int[][] dp = new int[n][m+1];
		
		for(int i = 0; i < n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		if(s + v[0] <= m) dp[0][s+v[0]] = 1;
		if(s - v[0] >= 0) dp[0][s-v[0]] = 1;
		
		for(int i = 1; i < n; i++) {
			int changeV = v[i], prev = i - 1;
			for(int j = 0; j <= m; j++) {
				if(dp[prev][j] == 1) {
					if(j + v[i] <= m ) dp[i][j+v[i]] = 1;
					if(j - v[i] >= 0 ) dp[i][j-v[i]] = 1;
				}
			}
		}
		int answer = -1;
		for(int i = 0; i <= m; i++) {
			if(dp[n-1][i] == 1) {
				answer = Math.max(answer,i);
			}
		}
		System.out.println(answer);
	}

}
