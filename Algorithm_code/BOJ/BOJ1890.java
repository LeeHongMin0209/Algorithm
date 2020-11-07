package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1890 {
	
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][n+1];
		int[][] map = new int[n+1][n+1];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == n-1 && j == n-1) continue;
				int next = map[i][j];
				if(i + next < n) {
					dp[i+next][j] += dp[i][j];
				}
				if(j + next < n) {
					dp[i][j+next] += dp[i][j];
				}
			}
		}
//		 for(int i = 0; i < n; i++){
//	            for(int j = 0; j < n; j++){
//	                System.out.print(dp[i][j]+" ");
//	            }
//	        System.out.println();
//	        }
		System.out.println(dp[n-1][n-1]);
	}
    public static void print(long[][] dp){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(dp[i][j]+" ");
            }
        System.out.println();
        }
        
    }
}
