package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2448 {
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		map = new int[n][2*n-1];
		func(n, 0, n-1);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2*n-1; j++) {
				if(map[i][j] == 1) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void func(int n,int x, int y) {
		if(n == 3) {
			map[x][y] = 1;
			map[x+1][y-1] = 1;
			map[x+1][y+1] = 1;
			map[x+2][y-2] = 1;
			map[x+2][y-1] = 1;
			map[x+2][y] = 1;
			map[x+2][y+1] = 1;
			map[x+2][y+2] = 1;
			return;
		}
		if(n > 3) {
			func(n/2, x, y);
			func(n/2, x+n/2, y-(n/2));
			func(n/2, x+n/2, y+(n/2));
		}
	}
}
