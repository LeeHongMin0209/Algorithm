package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class terrainMovement {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean[][] visited;
	static int[][] cost;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n;
	public static void main(String[] args) {
		int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
		int height = 3;
		int ans = solution(land, height);
		System.out.println(ans);
	}
	static public int solution(int[][] land, int height) {
		int answer = 0;
		n = land.length;
		cost = new int[n][n];
		for(int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
			
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dot d = new dot(i, j);
				bfs(d, land, height);
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				answer += cost[i][j];
				System.out.print(cost[i][j] + " ");
			}
			System.out.println();
		}
		return answer;
	}
	static void bfs(dot start, int[][] land, int height) {
		Queue<dot> qu = new LinkedList<>();
		qu.add(start);
		while(!qu.isEmpty()) {
			dot d = qu.poll();
			int x = d.x;
			int y = d.y;
			for(int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= n || yy < 0 || yy >= n) continue;
				int h;
				if(Math.abs(land[x][y] - land[xx][yy]) > height) {
					h = Math.abs(land[x][y] - land[xx][yy]);
				} else {
					h = 0;
				}
				
				if(cost[xx][yy] > h) {
					cost[xx][yy] = h;
					qu.add(new dot(xx, yy));
				}
			}	
		}	
	}
}
