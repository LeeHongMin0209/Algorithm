package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ2579 {
	static int[] arr = new int[305];
	static int[][] dp = new int[305][3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1][1] = arr[1];
		dp[1][2]  = 0;
		dp[2][1] = arr[2];  
		dp[2][2] = dp[1][1] + arr[2];
		for(int i = 3; i <= n; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + arr[i];
			dp[i][2] = dp[i-1][1] + arr[i];
		}
		System.out.println(Math.max(dp[n][1], dp[n][2]));
	}

}
