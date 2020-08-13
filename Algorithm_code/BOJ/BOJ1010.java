package BOJ;

import java.util.Scanner;

public class BOJ1010 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dp = new int[31][31];
		dp[1][0] = 1;
		dp[1][1] = 1;
		for(int i = 2; i <= 30; i++){
			dp[i][0] = 1;
			for(int j = 1; j <= 30; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.println(dp[m][n]);
		}

	}

}
