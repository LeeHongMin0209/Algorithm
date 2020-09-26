package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[100002];
		int[] dp = new int[100002];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = arr[1];
		for(int i = 2; i <= n; i++) {
			dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
		}
		int ans = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			ans = Math.max(dp[i], ans);
		}
		System.out.println(ans);
	}

}
