package BOJ;

import java.util.Scanner;

public class BOJ1720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[31];
		int[] sym = new int[31];
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-2] * 2 + dp[i-1]);
		}
		sym[1] = 1;
		sym[2] = 3;
		for(int i = 3; i <= n; i++) {
			if(i % 2 == 0) sym[i] = (dp[i/2] + dp[i/2 - 1] * 2 + dp[i]) / 2;
			else sym[i] = (dp[i/2] + dp[i]) / 2;
		}
		System.out.println(sym[n]);
	}

}
