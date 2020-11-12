package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1965 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		for(int i = 1; i <= n; i++){
			for(int j = 1; j < i; j++) {
				if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
				
			}
		}
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			ans = Math.max(dp[i], ans);
		}
		
		System.out.println(ans);
	}
	
// 1 2 1 2 3 1 2 3 2 3 4 5 6 6 6 2 3 3 3 4 4 3 4 5 4 4 4 5 6 5 
// 1 2 1 3 4 1 2 3 2 3 4 5 6 6 6 2 7 3 3 8 8 3 7 9 4 4 4 5 6 5
}
