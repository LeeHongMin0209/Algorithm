package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502 {
	static class virus{
		int x;
		int y;
		public virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n,m;
	static int[][] map, tempmap;
	static ArrayList<virus> virusList = new ArrayList<>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};   
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j  < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==2) virusList.add(new virus(i, j));
			}
		}
		wall(0,0);
		System.out.println(max);
	}
	static private void wall(int index, int cnt) {
		
		if(cnt == 3) {
			copy();
			for(virus v : virusList) {				
				bfsvirus(v);
			}
			
			int safeNum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(tempmap[i][j] == 0) safeNum++;
				}
			}
			max = Math.max(safeNum,max);
			return;
		}
		
		for(int i = index; i < n*m; i++) {
			int x = i / m;
			int y = i % m;
			
			if(map[x][y] == 0) {
				map[x][y] = 1;
				wall(index + 1, cnt + 1);
				map[x][y] = 0;
			}
		}		
	}
	
	static private void copy() {
		tempmap = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				tempmap[i][j] = map[i][j];
			}
		}
	}
	
	static private void bfsvirus(virus v) {
		Queue<virus> qu = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		qu.add(v);
		visited[v.x][v.y] = true;
		
		while(!qu.isEmpty()) {
			virus vi = qu.poll();
			
			for(int i = 0; i < 4; i++) {
				int x1 = vi.x + dx[i];
				int y1 = vi.y + dy[i];
				
				if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
				if(!visited[x1][y1] && tempmap[x1][y1] == 0) {
					qu.add(new virus(x1, y1));
					tempmap[x1][y1] = 2;
					visited[x1][y1] = true;
				}
			}
		}
	}	
}
