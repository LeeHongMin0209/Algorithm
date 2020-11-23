package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
	static int n,m,ans;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ans = 0;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[500][500];
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < m; j++) {
				tech1(i, j);
				tech2(i, j);
				tech3(i, j);
				tech4(i, j);
				tech5(i, j);
			}
		}
		
		System.out.println(ans);
	}
	// び
	static void tech1(int i, int j) {
		if(i+3 < n) {
			ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i+2][j]+map[i+3][j]);
		}
		if(i-3 >= 0) {
			ans = Math.max(ans, map[i][j]+map[i-1][j]+map[i-2][j]+map[i-3][j]);
		}
		if(j + 3 < m) {
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j+2]+map[i][j+3]);
		}
		if(j - 3 >= 0) {
			ans = Math.max(ans, map[i][j]+map[i][j-1]+map[i][j-2]+map[i][j-3]);
		}
	}
	// け
	static void tech2(int i, int j) {
		if(i+1 < n && j+1 < m) {
			ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i][j+1]+map[i+1][j+1]);
		}
	}
	// い
	static void tech3(int i, int j) {
		if(j + 1 < m && i + 2 < n) {
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+2][j+1]);
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i+1][j]+map[i+2][j]);
		}
		if(j + 1 < m && i - 2 >= 0) {
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i-1][j+1]+map[i-2][j+1]);
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i-1][j]+map[i-2][j]);
		}
		if(j + 2 < m && i + 1 < n) {
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+2]);
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j]);
		}
		if(j + 2 < m && i - 1 >= 0) {
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j+2]+map[i-1][j+2]);
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j+2]+map[i-1][j]);
		}
	}
	// で
	static void tech4(int i, int j) {
		if(j+1 < m && i-1 >= 0 && i+1 < n) {
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i-1][j]+map[i+1][j]);			
		}
		if(j+1 < m && j -1 >= 0 && i+1 < n) {
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i][j-1]+map[i+1][j]);
		}
		if(j-1 >= 0 && i+1 < n && i-1 >= 0) {
			ans = Math.max(ans, map[i][j]+map[i][j-1]+map[i+1][j]+map[i-1][j]);			
		}
		if(i-1 >= 0 && j+1 < m && j-1 >= 0) {
			ans = Math.max(ans, map[i][j]+map[i-1][j]+map[i][j+1]+map[i][j-1]);			
		}
	}
	// 
	static void tech5(int i, int j) {
		if(j-1 >= 0 && i-2 >= 0) {
			ans = Math.max(ans, map[i][j]+map[i-1][j]+map[i-1][j-1]+map[i-2][j-1]);
		}
		if(i-2 >= 0 && j+1 < m) {
			ans = Math.max(ans, map[i][j]+map[i-1][j]+map[i-1][j+1]+map[i-2][j+1]);
		}
		if(j-1 >= 0 && i + 2 < n) {
			ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i+1][j-1]+map[i+2][j-1]);
		}
		if(j + 1 < m && i + 2 < n) {
			ans = Math.max(ans, map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+2][j+1]);
		}
		if(j-2 >= 0 && i-1 >= 0) {
			ans = Math.max(ans, map[i][j]+map[i][j-1]+map[i-1][j-1]+map[i-1][j-2]);
		}
		if(i-1 >= 0 && j+2 < m) {
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i-1][j+1]+map[i-1][j+2]);
		}
		if(j-2 >= 0 && i+1 < n) {
			ans = Math.max(ans, map[i][j]+map[i][j-1]+map[i+1][j-1]+map[i+1][j-2]);
		}
		if(j+2 < m && i+1 < n) {
			ans = Math.max(ans, map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+1][j+2]);
		}
		
	}
}
