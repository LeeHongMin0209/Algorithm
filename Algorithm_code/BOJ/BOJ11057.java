package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11057 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[1002][10];
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][j] += dp[i-1][k] % 10007;
				}
			}
		}
		int ans = 0;
		for(int j = 0; j < 10; j++) {
			ans += dp[n][j];
		}
		System.out.println(ans  % 10007);
	}
}
