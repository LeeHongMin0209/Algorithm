package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2302 {
	static int n,m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		int ans = 1;
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		int start = 1;
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(br.readLine());
			ans *= dp[num - start];
			start = num+1;
		}
		ans *= dp[n - (start-1)];
		System.out.println(ans);
	}

}

