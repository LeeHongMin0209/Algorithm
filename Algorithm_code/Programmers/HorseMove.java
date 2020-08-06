package Programmers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class HorseMove {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] numPlate;
	static int[][] visited;
	static int n,answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			answer = 0;
			n = Integer.parseInt(br.readLine());
			numPlate = new int[n+1][n+1];
			visited = new int[n+1][n+1];
			for(int j = 1; j <= n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int k = 1; k <= n; k++) {
					numPlate[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(1,1);
			System.out.println("#" + (i+1) +" "+ answer);
		}

	}
	static void bfs(int x, int y) {
		Queue<dot> qu = new LinkedList<>();
		qu.add(new dot(x, y));
		visited[x][y]++;
		
		loop : while(!qu.isEmpty()) {
			int size = qu.size();
			
			for(int j = 0; j < size; j++) {
				
				dot d = qu.poll();
				
				if(d.x == n && d.y == n) break loop;
				
				int max = numPlate[d.x][d.y];
				for(int i = 1; i <= max; i++) {
					int tx = d.x + i;
					if(tx < n+1 && d.y < n+1 && visited[tx][d.y] == 0) {
						visited[tx][d.y]++;
						qu.add(new dot(tx, d.y));
					}
				}
				for(int i = 1; i <= max; i++) {
					int ty = d.y + i;
					if(d.x < n+1 && ty < n+1 && visited[d.x][ty] == 0) {
						visited[d.x][ty]++;
						qu.add(new dot(d.x, ty));
					}
				}
			}
			answer++;
		}
		
	}
}
