package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14588 {
	static class dot{
		int start;
		int end;
		public dot(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dot[] arr = new dot[n+2];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			dot d = new dot(start, end);
			arr[i] = d;
		}
		int[][] map = new int[305][305];
		for(int i = 1; i <= n; i++) {
			Arrays.fill(map[i], 10000001);			
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				dot d1 = arr[i];
				dot d2 = arr[j];
				if(d2.start >= d1.start && d2.start <= d1.end) {
					map[i][j] = map[j][i] = 1;
				}
				if(d2.end >= d1.start && d2.end <= d1.end) {
					map[i][j] = map[j][i] = 1;
				}
			}
		}
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		int q = Integer.parseInt(br.readLine());
		for(int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(map[x][y] == 10000001) map[x][y] = -1;
			System.out.println(map[x][y]);
		}
	}

}
