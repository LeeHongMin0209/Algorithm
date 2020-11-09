package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10164 {
	static int n,m,k;
	static int[][] map;
	static long[][] dp;
	static int[] dx = {1,0};
	static int[] dy = {0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		dp = new long[n+1][m+1];
		int x = 0;
		int y = 0;
		int num = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(num == k) {
					x = i;
					y = j;
				}
				map[i][j] = num;
				dp[i][j] = -1;
				num++;
			}
		}
		long first = dfs(0,0,x,y);
		long end = dfs(x,y,n-1,m-1);
		System.out.println(first * end);
		
//		for(int i1 = 0; i1 < n; i1++) {
//			for(int j = 0; j < m; j++) {
//				System.out.print(dp[i1][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
	}
	static long dfs(int x, int y, int N, int M) {
		
		if(x == N && y == M) return 1;
		
		if(dp[x][y] == -1) {
			dp[x][y] = 0;
			for(int i = 0; i < 2; i++) {
				int xx = dx[i] + x;
				int yy = dy[i] + y;
				if(xx >= 0 && xx <= N && yy >= 0 && y <= M) {
					dp[x][y] += dfs(xx,yy,N,M);
//					for(int i1 = 0; i1 < n; i1++) {
//						for(int j = 0; j < m; j++) {
//							System.out.print(dp[i1][j] + " ");
//						}
//						System.out.println();
//					}
//					System.out.println();
				}
			}
		}
		return dp[x][y];
	}
}
