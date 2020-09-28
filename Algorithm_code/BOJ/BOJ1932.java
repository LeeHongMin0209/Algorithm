package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[502][502];
		String[] arr = new String[502];
		for(int i = 1; i <= n; i++) {
			arr[i] = br.readLine();
		}
		dp[1][0] = Integer.parseInt(arr[1]);
		for(int i = 2; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(arr[i]);
			for(int j = 0; j < i; j++) {
				if(j == 0) dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i-1][j];
				else if(j == arr[i].length()-1) dp[i][j] = Integer.parseInt(st.nextToken())+ dp[i-1][j];
				else dp[i][j] = Integer.parseInt(st.nextToken()) + Math.max(dp[i-1][j-1], dp[i-1][j]); 
			}
		}
		int ans= 0;
		for(int i = 0; i < n; i++) {
			ans = Math.max(dp[n][i], ans);
		}
		System.out.println(ans);
	}

}
