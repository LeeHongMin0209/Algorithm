package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] map, dp;
	static int m, n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m+1][n+1];
		dp = new int[m+1][n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(m-1, n-1));
	}
	static int dfs(int y, int x) {
		if(y == 0 && x == 0) return 1;
		
		if(dp[y][x] == -1) {
			dp[y][x] = 0;
			for(int z = 0; z < 4; z++) {
				int nx = dx[z] + x;
				int ny = dy[z] + y;
				
				if(0 <= nx && nx < n && 0 <= ny && ny < m) {
					if(map[y][x] < map[ny][nx]) {
						for(int i = 0; i < m; i++){
							for(int j = 0; j < n; j++){
								System.out.print(dp[i][j]+" ");
							}
							System.out.println();
						}
						System.out.println();
						dp[y][x] += dfs(ny,nx);
					}
				}
			}
		}
		return dp[y][x];
	}
}
