package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684 {
	static int n, l, ans;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			boolean check = true;
			int cur = map[i][0];
			int curL1 = 0;
			int curL2 = 0;
			loop : for(int j = 1; j < n; j++) {
				if(map[i][j] == cur && curL2 == 0) { 
					cur = map[i][j];
					continue;
				}
				else if(map[i][j] - cur == 1) {
					if(j-l < 0) {
						check = false;
						break loop;
					}
					for(int k = j-1; k >= j-l; k-- ) {
						if(visited[i][k]) {
							check = false;
							break loop;
						}
						visited[i][k] = true;
						if(map[i][j] - map[i][k] == 1) curL1++;
						else {
							check = false;
							break loop;
						}
					}
					if(curL1 < l) {
						check = false;
						break loop;
					}
					cur = map[i][j];
				}
				else if(cur - map[i][j] == 1) {
					if(visited[i][j]) {
						check = false;
						break loop;
					}
					curL2 ++;
					visited[i][j] = true;
					if(curL2 == l) {
						cur = map[i][j];
						curL2 = 0;
					}
				}
				else {
					check = false;
					break;
				}
			}
			if(curL2 != 0 && curL2 != l) check = false; 
			if(check) {
				ans++;
			}
			
			
		}
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			boolean check = true;
			int cur = map[0][i];
			int curL1 = 0;
			int curL2 = 0;
			loop : for(int j = 1; j < n; j++) {
				if(map[j][i] == cur && curL2 == 0) { 
					cur = map[j][i];
					continue;
				}
				else if(map[j][i] - cur == 1) {
					if(j-l < 0) {
						check = false;
						break loop;
					}
					for(int k = j-1; k >= j-l; k-- ) {
						if(visited[k][i]) {
							check = false;
							break loop;
						}
						visited[k][i] = true;
						if(map[j][i] - map[k][i] == 1) curL1++;
						else {
							check = false;
							break loop;
						}
					}
					if(curL1 < l) {
						check = false;
						break loop;
					} else {
						
						curL1 = 0;
					}
					cur = map[j][i];
				}
				else if(cur - map[j][i] == 1) { 
					if(visited[j][i]) {
						check = false;
						break loop;
					}
					curL2 ++;
					visited[j][i] = true;
					if(curL2 == l) {
						cur = map[j][i];
						curL2 = 0;
					}
				}
				else {
					check = false;
					break;
				}
			}
			if(curL2 != 0 && curL2 != l) check = false; 
			if(check) ans++;
		}
		
		System.out.println(ans);
	}

}
