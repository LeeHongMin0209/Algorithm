package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ1941 {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static String[][] map = new String[5][5];
	static dot[] arr = new dot[7];
	static ArrayList<dot> list = new ArrayList<>();
	static boolean[] visted = new boolean[25];
	static boolean[][] check;
	static int num, ans;
	static int nnn;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++) {
			String str = br.readLine();
			for(int j = 0; j < 5; j++) {
				String s = String.valueOf(str.charAt(j));
				map[i][j] = s;
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				dot d = new dot(i, j);
				list.add(d);
			}
		}
		func(0);
		System.out.println(ans);
	}
	static void func(int k) {
		if(k == 7) {
			int cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				if(map[arr[i].x][arr[i].y].equals("S")) {
					cnt++;
				}
			}
			if(cnt >= 4) {
				num = 0;
				check = new boolean[5][5];
				bfs(arr[0]);
				if(num == 7) {
					ans++;
				}
			}
			return;
		}
		for(int i = 0; i < list.size(); i++) {
			if(!visted[i]) {
				arr[k] = list.get(i);
				visted[i] = true;
				if(k == 0) func(k + 1);
				if(k > 0 && check(arr[k-1], list.get(i))) func(k+1);
				visted[i] = false;
			}
		}
	}
	static boolean check(dot d1, dot d2) {
		if(d1.x < d2.x) return true;
		else if(d1.x == d2.x) {
			if(d1.y < d2.y) return true;
		}
		return false;
	}
	static void bfs(dot start) {
		Queue<dot> qu = new LinkedList<>();
		int x = start.x;
		int y = start.y;
		check[x][y] = true;
		qu.add(start);
		num++;
		while(!qu.isEmpty()) {
			dot d = qu.poll();
			for(int i = 0; i < 4; i++) {
				int xx = d.x + dx[i];
				int yy = d.y + dy[i];
				
				if(xx >= 0 && xx < 5 && yy >= 0 && yy < 5) {
					dot tmp = new dot(xx, yy);
					if(!check[xx][yy] && contain(tmp)) {
						qu.add(tmp);
						check[xx][yy] = true;
						num++;
					}
				}
			}
		}
	}
	static boolean contain(dot tmp) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].x == tmp.x && arr[i].y == tmp.y) return true;
		}
		return false;
	}
}
