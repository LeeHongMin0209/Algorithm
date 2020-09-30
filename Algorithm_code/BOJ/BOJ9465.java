package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][100002];
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[2][100002];
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			dp[0][2] = arr[1][1] + arr[0][2];
			dp[1][2] = arr[0][1] + arr[1][2];
			int ans = 0;
			for(int i = 3; i <= n; i++) {
				dp[0][i] = Math.max(Math.max(dp[0][i-2], dp[1][i-2]),dp[1][i-1]) + arr[0][i];
				dp[1][i] = Math.max(Math.max(dp[0][i-2], dp[1][i-2]),dp[0][i-1]) + arr[1][i];
				int tmp = Math.max(dp[0][i], dp[1][i]);
				ans = Math.max(tmp, ans);
			}
			System.out.println(ans);
		}
	}

}
