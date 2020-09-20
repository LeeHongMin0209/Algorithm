package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
	static StringBuilder sb = new StringBuilder();
	static int[][] map = new int[64][64];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j <str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		func(n,0,0);
		System.out.println(sb.toString());
	}
	static void func(int n,int x, int y) {
		int num = map[x][y];
		boolean check = true;
		loop : for(int i = x; i < x + n; i++) {
			for(int j = y; j < y + n; j++) {
				if(num != map[i][j]) {
					check = false;
					break loop;
				}
			}
		}

		if(!check) {
			sb.append("(");
			func(n/2, x, y);
			func(n/2, x, y + n/2);
			func(n/2, x + n/2, y);
			func(n/2, x + n/2, y + n/2);
			sb.append(")");					
		} else {
			sb.append(num);
		}		
		
	}
}
