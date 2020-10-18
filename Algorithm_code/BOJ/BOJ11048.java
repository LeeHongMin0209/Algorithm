package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11048 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+2][m+2];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				map[i][j] += Math.max(map[i][j-1], map[i-1][j]);
			}
		}
		System.out.println(map[n][m]);
	}

}
