package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11048 {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {1,0,1};
	static int[] dy = {0,1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] visited = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<dot> qu = new LinkedList<BOJ11048.dot>();
		qu.add(new dot(0, 0));
		visited[0][0] = map[0][0];
		while(!qu.isEmpty()) {
			dot d = qu.poll();
			for(int i = 0; i < 3; i++) {
				int xx = d.x + dx[i];
				int yy = d.y + dy[i];
				
				if(xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
				if(visited[d.x][d.y] >= visited[xx][yy]) {
					qu.add(new dot(xx, yy));
					visited[xx][yy] = visited[d.x][d.y] + map[xx][yy];
				}
			}
		}
		System.out.println(visited[n-1][m-1]);
	}

}
