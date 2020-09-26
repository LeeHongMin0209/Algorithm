package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+3][3];
		int[][] dp = new int[n+3][3];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		dp[1][0] = arr[1][0];
		dp[1][1] = arr[1][1];
		dp[1][2] = arr[1][2];
		for(int i = 2; i  <= n; i++) {
			dp[i][0] = Math.min(arr[i][0] + dp[i-1][1], arr[i][0] + dp[i-1][2]);
			dp[i][1] = Math.min(arr[i][1] + dp[i-1][0], arr[i][1] + dp[i-1][2]);
			dp[i][2] = Math.min(arr[i][2] + dp[i-1][0], arr[i][2] + dp[i-1][1]);
		}
		int ans = Math.min(dp[n][0], dp[n][1]);
		System.out.println(Math.min(ans, dp[n][2]));
	}
}
			
