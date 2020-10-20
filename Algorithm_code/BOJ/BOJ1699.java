package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1699 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[100002];
		int tmp = 1;
		while(true) {
			int num = tmp * tmp;
			if(num > dp.length) break;
			dp[num] = 1;
			tmp++;
		}
		
		for(int i = 2; i < dp.length; i++) {
			if(dp[i] == 0) {
				dp[i] = dp[i-1];
				int x = 2;
				while(true) {
					if(i - x * x <= 0) break;
					dp[i] = Math.min(dp[i], dp[i - x*x]);
					x++;
				}
				dp[i]++;
			}
		}
		System.out.println(dp[n]);
	}
}
