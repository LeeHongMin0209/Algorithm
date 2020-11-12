package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1915 {
	static int n,m;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n == 1 && m == 1) System.out.println(1);
		else {
			int ans = 0;
			
			int[][] dp = new int[n+1][m+1];
			for(int i = 1; i <= n; i++) {
				String str = sc.next();
				for(int j = 1; j <= m; j++) {
					int temp = str.charAt(j-1) - '0';
					
					if(i == 1 && j == 1) {
						dp[i][j] = temp;
					} else {
						if(temp == 1) {
							dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
							ans = Math.max(ans, dp[i][j]);
						}
					}
				}
			}
			System.out.println(ans*ans);
		}
	}

}
