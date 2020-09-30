package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			long[] dp = new long[102];
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			for(int i = 4; i <= n; i++) {
				dp[i] = dp[i-3] + dp[i-2];
			}
			System.out.println(dp[n]);
		}
	}

}
