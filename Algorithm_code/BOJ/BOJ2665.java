package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2665 {
	static class dot{
		int x;
		int y;
		public dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map, visited;
	static int n;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+2][n+2];
		visited = new int[n+2][n+2];
		for(int i = 1; i <= n; i++) {
			String str = br.readLine();
			for(int j = 1; j <= n; j++) {
				map[i][j] = str.charAt(j-1) - 48;
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs(1, 1);
		System.out.println(visited[n][n]);
	}
	static void bfs(int stX, int stY) {
		Queue<dot> qu = new LinkedList<>();
		dot d = new dot(stX, stY);
		visited[stX][stY] = 0;
		qu.add(d);
		
		while(!qu.isEmpty()) {
			dot dot = qu.poll();
			int x = dot.x;
			int y = dot.y;
			for(int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if(newX > 0 && newX <= n && newY > 0 && newY <= n) {
					if(visited[x][y] < visited[newX][newY]) {
						if(map[newX][newY] == 1) {
							qu.add(new dot(newX, newY));
							visited[newX][newY] = visited[x][y];
						} else {
							qu.add(new dot(newX, newY));
							visited[newX][newY] = visited[x][y] + 1;
						}
					}
				}
			}
		}
	}
}
