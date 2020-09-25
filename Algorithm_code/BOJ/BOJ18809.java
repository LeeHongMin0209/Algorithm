package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18809 {
	static class Pos{
		int x;
		int y;
		int time;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
			this.time = 0;
		}
	}
	static class Pair{
		int time;
		int type;
		Pair(){
			
		}
		public Pair(int time, int type) {
			this.time = time;
			this.type = type;
		}
	}
	static int row, col;
	static int green, red;
	static int[][] garden;
	static ArrayList<Pos> possible;
	static boolean[] visited;
	static int[] greens, reds;
	static int max;
	static final int RED = 3;
	static final int GREEN = 4;
	static final int FLOWER = 5;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		green = Integer.parseInt(st.nextToken());
		red = Integer.parseInt(st.nextToken());
		possible = new ArrayList<>();
		
		garden = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
				if(garden[i][j] == 2) possible.add(new Pos(i, j));
			}
		}
		greens = new int[green];
		reds = new int[red];
		visited = new boolean[10];
		perm_green(0, 0);
		System.out.println(max);
	}
	
	static void perm_green(int start, int r) {
		if(r == green) {
			perm_red(0,0);
			return;
		}
		for(int i = start; i < possible.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				greens[r] = i;
				perm_green(i+1, r+1);
				visited[i] = false;
			}
		}
	}
	static void perm_red(int start, int r) {
		if(r == red) {
			bfs();
			return;
		}
		for(int i = start; i < possible.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				reds[r] = i;
				perm_red(i+1, r+1);
				visited[i] = false;
			}
		}
	}
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		Pair[][] state = new Pair[row][col];
		for(int i = 0; i< row; i++)
			for(int j = 0; j< col; j++)
				state[i][j] = new Pair();
		
		for(int i = 0; i < red; i++) {
			Pos p = possible.get(reds[i]);
			state[p.x][p.y] = new Pair(0, RED);
			q.add(p);
		}
		for(int i = 0; i < green; i++) {
			Pos p = possible.get(greens[i]);
			state[p.x][p.y] = new Pair(0, GREEN);
			q.add(p);
		}
		int sum = 0;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int x = p.x;
			int y = p.y;
			int curtime = state[x][y].time;
			int curtype = state[x][y].type;
			if(state[x][y].type == FLOWER) continue;
			
			for(int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(isValidPosition(xx, yy) && garden[xx][yy] != 0) {
					
					if(state[xx][yy].type == 0) {
						state[xx][yy] = new Pair(curtime+1, curtype);
						q.add(new Pos(xx, yy));					
					} else if(state[xx][yy].type == RED) {		
						if(curtype == GREEN && state[xx][yy].time == curtime + 1) {
							sum++;
							state[xx][yy].type = FLOWER;
						}						
					} else if(state[xx][yy].type == GREEN) {
						if(curtype == RED && state[xx][yy].time == curtime + 1) {
							sum++;
							state[xx][yy].type = FLOWER;
						}
					}
				}
			}
		}
		max = max < sum ? sum : max;
	}
	private static boolean isValidPosition(int x, int y){
		if(x < 0 || y < 0 || x >= row || y >= col) return false;
		return true;
	}
}
