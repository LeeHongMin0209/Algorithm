package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp1 = new int[n+1];
		int[] dp2 = new int[n+1];
		int[] ans = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp1[i] = 1;
			dp2[i] = 1;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				if(arr[i] > arr[j]) dp1[i] = Math.max(dp1[i], dp1[j] + 1);
			}
		}
		for(int i = n-1; i >= 1; i--) {
			for(int j = n; j > i; j--) {
				if(arr[i] > arr[j]) dp2[i] = Math.max(dp2[i], dp2[j] + 1);
			}
		}
		int maxLen = 0;
		for(int i = 1; i <= n; i++) {
//			System.out.print(dp1[i] + " ");
			ans[i] = dp1[i] + dp2[i] -1;
			maxLen = Math.max(maxLen, ans[i]);
		}
//		System.out.println();
//		for(int i = 1; i <= n; i++) {
//			System.out.print(dp2[i] + " ");
//			
//		}
//		System.out.println();
		System.out.println(maxLen);
	}

}
