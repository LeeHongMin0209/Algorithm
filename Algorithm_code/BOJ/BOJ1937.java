package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1937 {
	static int n,ans;
	static int[][] map,dp;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ans = Math.max(ans, dfs(i,j));
			}
		}
		System.out.println(ans);
	}
	static int dfs(int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];
		
		int day = 1;
		for(int i = 0; i < 4; i++) {
			int xx = dx[i] + x;
			int yy = dy[i] + y;
			if(xx >= 0 && xx < n && yy >= 0 && yy < n) {
				if(map[xx][yy] > map[x][y]) {
					day = Math.max(dfs(xx,yy) + 1, day);
					dp[x][y] = day;
				}
			}
		}
		return day;
	}
}
