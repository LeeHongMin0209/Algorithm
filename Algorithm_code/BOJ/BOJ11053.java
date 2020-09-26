package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[1002];
		int[] dp = new int[1002];
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = 1;
		int max = arr[1];
		for(int i = 2; i <= n; i++) {
			dp[i] = 1;
			for(int j = 1; j < i; j++) {
				if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		max = 0;
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
