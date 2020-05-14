package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BOJ2667 {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int dan;	
	static ArrayList<Integer> answer = new ArrayList<>();
	
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];		
		
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < str.length; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}			
		}
		bfs();
		Collections.sort(answer);
		
		System.out.println(dan-1);
		for(int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
	
	static private void bfs() {
		Queue<dot> qu = new LinkedList<>();
		dan = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					qu.add(new dot(i, j));
					visited[i][j] = true;
					map[i][j] = dan;
					int cnt = 1;
					
					while(!qu.isEmpty()) {
						dot d = qu.poll();
						for(int k = 0; k < 4; k++) {
							int x1 = d.x + dx[k];
							int y1 = d.y + dy[k];
							
							if(x1 < 0 || x1 >= n || y1 < 0 || y1>= n) continue;
							if(map[x1][y1] == 1 && !visited[x1][y1]) {
								qu.add(new dot(x1, y1));
								visited[x1][y1] = true;
								map[x1][y1] = dan;
								cnt++;
							}
						}
					}
					dan++;
					answer.add(cnt);
				}
			}
		}
	}

}
