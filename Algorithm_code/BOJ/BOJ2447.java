package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		boolean check = true;
		func(n, true,0,0);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void func(int n, boolean check, int x, int y) {
		if(n == 1 && check) {
			map[x][y] = 1;
			return;
		}
		if(n >= 3) {
			func(n/3,check,x,y);
			func(n/3,check,x,y+n/3);
			func(n/3,check,x,y+(n/3*2));
			func(n/3,check,x+n/3,y);
			func(n/3,false,x+n/3,y+n/3);
			func(n/3,check,x+n/3,y+(n/3*2));
			func(n/3,check,x+(n/3*2),y);
			func(n/3,check,x+(n/3*2),y+n/3);
			func(n/3,check,x+(n/3*2),y+(n/3*2));		
		}		
	}
}
