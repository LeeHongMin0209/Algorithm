package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] color = new int[n+1][3];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			color[i][0] = Integer.parseInt(st.nextToken());
			color[i][1] = Integer.parseInt(st.nextToken());
			color[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[1001][3];
		dp[1][0] = color[1][0];
		dp[1][1] = color[1][1];
		dp[1][2] = color[1][2];
		for(int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + color[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + color[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + color[i][2];
		}
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
	}
}
