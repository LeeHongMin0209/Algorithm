package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ15683 {
	static class cctv{
		int x;
		int y;
		public cctv(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n,m,ans;
	static int[][] map1 = new int[10][10];
	static int[][] map2 = new int[10][10];
	static Vector<cctv> vec = new Vector<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) { 
				map1[i][j] = Integer.parseInt(st.nextToken());
				if(map1[i][j] != 0 && map1[i][j] != 6) vec.add(new cctv(i, j));
				if(map1[i][j] == 0) ans++;
			}
		}
		int size = 1;
		for(int i = 0; i < vec.size(); i++) size *= 4;
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					map2[j][k] = map1[j][k];
				}
			}
			int brute = i;
			for(int j = 0; j < vec.size(); j++) {
				int dir = brute % 4;
				brute /= 4;
				int x = vec.get(j).x;
				int y = vec.get(j).y;
				if(map1[x][y] == 1) {
					upd(x, y, dir);
				} else if(map1[x][y] == 2) {
					upd(x, y, dir);
					upd(x, y, dir+2);
				} else if(map1[x][y] == 3) {
					upd(x, y, dir);
					upd(x, y, dir+1);
				} else if(map1[x][y] == 4) {
					upd(x, y, dir);
					upd(x, y, dir+1);
					upd(x, y, dir+2);
				} else if(map1[x][y] == 5) {
					upd(x, y, dir);
					upd(x, y, dir+1);
					upd(x, y, dir+2);
					upd(x, y, dir+3);
				}
			}
			
			int val = 0;
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(map2[j][k] == 0) val++;
				}
			}
			ans = Math.min(ans, val);
		}
		System.out.println(ans);
	}
	
	static boolean isRanged(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= m;
	}
	
	static void upd(int x,int y, int dir) {
		dir %= 4;
		while(true) {
			x += dx[dir];
			y += dy[dir];
			if(isRanged(x, y) || map2[x][y] == 6) return;
			if(map2[x][y] != 0) continue;
			map2[x][y] = 7;
		}
	}
}
