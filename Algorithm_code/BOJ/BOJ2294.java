package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2294 {
	// 3 10
	//1, 2, 5
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[102];
		int[] dp = new int[10002];
		for(int i = 1; i <= k; i++) {
			dp[i] = 10002;
		}
		for(int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i <= n; i++)
			for(int j = coin[i]; j <= k ; j++)
				dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
		
		if(dp[k] == 10002) System.out.println(-1);
		else System.out.println(dp[k]);
	}

}
