package BOJ;

import java.util.Scanner;

public class BOJ2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[][] dp = new int[301][3];
		dp[1][1] = arr[1];
		dp[1][2] = 0;
		if(n >= 2) {
			dp[2][1] = arr[2];
			dp[2][2] = arr[1] + arr[2];		
		}
		for(int i = 3; i <= n; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + arr[i];
			dp[i][2] = dp[i-1][1] + arr[i];
		}
		System.out.println(Math.max(dp[n][1], dp[n][2]));
	}

}
