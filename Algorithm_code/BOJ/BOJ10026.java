package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10026 {
	static class color{
		int x;
		int y;
		public color(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n;
	static int cnt1 = 0;
	static int cnt2 = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) {
				map[i][j] = str[j];
			}
		}
		bfs1();
		System.out.print(cnt1 + " ");
		
		visited = new boolean[n][n];
		bfs2();
		System.out.println(cnt2);
		
	}
	static private void bfs1() {
		Queue<color> qu = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					qu.add(new color(i, j));
					visited[i][j] = true;
					
					while(!qu.isEmpty()) {
						color c = qu.poll();
						for(int k = 0; k < 4; k++) {
							int x1 = c.x + dx[k];
							int y1 = c.y + dy[k];
							if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= n) continue;
							if(map[x1][y1] == map[c.x][c.y] && !visited[x1][y1]) {
								qu.add(new color(x1, y1));
								visited[x1][y1] = true;
							}
						}
					}
					cnt1++;
				}
			}
		}
	}
	static private void bfs2() {
		Queue<color> qu = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					qu.add(new color(i, j));
					visited[i][j] = true;
					
					while(!qu.isEmpty()) {
						color c = qu.poll();
						for(int k = 0; k < 4; k++) {
							int x1 = c.x + dx[k];
							int y1 = c.y + dy[k];
							
							if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= n) continue;
							if(map[c.x][c.y] == 'B') {
								if(map[x1][y1] == 'B' && !visited[x1][y1]) {
									qu.add(new color(x1, y1));
									visited[x1][y1] = true;
								}
							} else {
								if(map[x1][y1] == 'G' || map[x1][y1] == 'R') {
									if(!visited[x1][y1]) {
										qu.add(new color(x1, y1));
										visited[x1][y1] = true;
									}
								}
							}
						}
					}
					cnt2++;
				}
			}
		}
	}
}
