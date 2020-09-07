package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
	static int[][] map = new int[52][52];
	static int n,m,r,c,dir,ans;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			int back = 0;
			int[] robot = clean(r, c, dir, back);
			if(robot[0] == r && robot[1] == c && robot[3] == 1) break;
			else {
				r = robot[0];
				c = robot[1];
				dir = robot[2];
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 2) ans++;
			}
		}
		System.out.println(ans);
	}
	static int[] clean(int x, int y, int dir,int back) {
		int[] arr = {x,y,dir,back};
		map[x][y] = 2;
		for(int i = 0; i < 4; i++) {
			dir %= 4;
			int x1 = x + dx[dir];
			int y1 = y + dy[dir];
			if(map[x1][y1] == 0) {
				map[x1][y1] = 2;
				arr[0] = x1;
				arr[1] = y1;
				dir += 3;
				arr[2] = dir;
				return arr;
			}
			dir += 3;
		}
	
		dir += 3;
		dir %= 4;
		x += dx[dir];
		y += dy[dir];
		if(map[x][y] == 1) {
			arr[0] = x - dx[dir];
			arr[1] = y - dy[dir];
			arr[2] = dir;
			arr[3] = 1;
			return arr;
		}
		else {
			arr[0] = x;
			arr[1] = y;
			dir++;
			arr[2] = dir;
			return arr;
		}
	}
}
