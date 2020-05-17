package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11559 {
	static String[][] map;
	static boolean[][] visited;
	static int ans;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class dot{
		int x;
		int y;
		String color;
		public dot(int x, int y, String color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new String[12][6];
		visited = new boolean[12][6];
		for(int i = 0; i < 12; i++) {
			String str = br.readLine();
			String[] Arr = str.split("");
			for(int j = 0; j < 6; j++) {
				map[i][j] = Arr[j];
			}
		}
		bfs();
		System.out.println(ans);
	}
	static void bfs() {
		Queue<dot> qu = new LinkedList<BOJ11559.dot>();
		Queue<dot> temp = new LinkedList<>();
		Queue<dot> info = new LinkedList<>();
		boolean run = true;
		while(run) {
			run = false;
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(!map[i][j].equals(".") && !visited[i][j]) {
						String color = map[i][j];
						qu.add(new dot(i, j, color));
						visited[i][j] = true;
						
						while(!qu.isEmpty()) {
							dot d = qu.peek();
							info.add(qu.poll());
							for(int k = 0; k < 4; k++) {
								int x1 = d.x + dx[k];
								int y1 = d.y + dy[k];
								
								if(x1 < 0 || x1 >= 12 || y1 < 0 || y1 >= 6) continue;
								
								if(map[x1][y1].equals(d.color) && !visited[x1][y1]) {
									qu.add(new dot(x1, y1, map[x1][y1]));
									visited[x1][y1] = true;
								}
							}
						}
						if(info.size() >= 4) {
							while(!info.isEmpty()) {
								temp.add(info.poll());
							}
						}
						info.clear();
					}
				}
			}			
			if(temp.size() >= 4) {
				while(!temp.isEmpty()) {
					dot d = temp.poll();
					map[d.x][d.y] = "."; 
				}
				while(true) {
					boolean check = true;
					for(int k = 0; k < 11; k++) {
						for(int z = 0; z < 6; z++) {
							if(!map[k][z].equals(".")) { 
								for(int r = k + 1; r <= 11; r++) {
									if(map[r][z].equals(".")) check = false;
								}
							}
						}
					}
					if(check) break;
					
					for(int k = 0; k < 11; k++) {
						for(int z = 0; z < 6; z++) {
							if(!map[k][z].equals(".")) {
								if(map[k+1][z].equals(".")) {
									map[k+1][z] = map[k][z];
									map[k][z] = ".";
								}
							}
						}
					}
				}
				run = true;
				visited = new boolean[12][6];
				ans++;
			}
			else if(temp.size() < 4){
				temp.clear();
				qu.clear();
			}						
		}
		
	}
}
