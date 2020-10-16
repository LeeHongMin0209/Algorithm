package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nhn01 {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> ansList = new ArrayList<>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.println(ansList.size());
		Collections.sort(ansList);
		for(int x : ansList) System.out.print(x + " ");
	}
	static void bfs(int x, int y) {
		int cnt = 0;
		Queue<dot> qu = new LinkedList<>();
		qu.add(new dot(x, y));
		visited[x][y] = true;
		cnt++;
		
		while(!qu.isEmpty()) {
			dot d = qu.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = d.x + dx[i];
				int yy = d.y + dy[i];
				
				if(xx < 0 || xx >= n || yy < 0 || yy >= n) continue;
				
				if(!visited[xx][yy] && map[xx][yy] == 1) {
					qu.add(new dot(xx, yy));
					visited[xx][yy] = true;
					cnt++;
				}
			}
		}
		ansList.add(cnt);
	}
}
