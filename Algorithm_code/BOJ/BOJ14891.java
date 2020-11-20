package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891 {
	static class dot{
		boolean check;
		int dir;
		public dot(boolean check, int dir) {
			this.check = check;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] top = new int[4][8];
		for(int i = 0; i < 4; i++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			for(int j = 0; j < 8; j++) {
				top[i][j] = ch[j] - 48;
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			num--;
			//left
			dot d1[] = new dot[4];
			for(int j = 0; j < 4; j++) d1[j] = new dot(false, 0);
				
			d1[num].check = true;
			d1[num].dir = dir;
			for(int j = num-1; j >= 0; j--) {
				if(top[j+1][6] != top[j][2]) {
					d1[j].check = true;
					d1[j].dir = -d1[j+1].dir;
				} else break;
			}
			
			//right
			dot[] d2 = new dot[4];
			for(int j = 0; j < 4; j++) d2[j] = new dot(false, 0);
			
			d2[num].check = true;
			d2[num].dir = dir;
			for(int j = num+1; j < 4; j++) {
				if(top[j-1][2] != top[j][6]) {
					d2[j].check = true;
					d2[j].dir = -d2[j-1].dir;
				} else break;
			}
			
			lotaion(top[num], dir);
			for(int j = 0 ; j < 4; j++) {
				if(d1[j].check && j != num) {
					lotaion(top[j], d1[j].dir);
				} 
			}
			for(int j = 0 ; j < 4; j++) {
				if(d2[j].check && j != num) {
					lotaion(top[j], d2[j].dir);
				}
			}
		}
		
//		for(int i = 0; i < 4; i++) {
//			for(int j = 0; j < 8; j++) {
//				System.out.print(top[i][j]);
//			}
//			System.out.println();
//		}
		
		int ans = 0;
		if(top[0][0] == 1) ans += 1;
		if(top[1][0] == 1) ans += 2;
		if(top[2][0] == 1) ans += 4;
		if(top[3][0] == 1) ans += 8;
		System.out.println(ans);
	}
	static private void lotaion(int[] to, int dir) {
		int[] copy = new int[8];
		for(int i = 0; i < 8; i++) {
			copy[i] = to[i];
		}
		if(dir == 1) {
			to[0] = copy[7];
			for(int i = 1; i < 8; i++) {
				to[i] = copy[i-1];
			}
		} else if(dir == -1){
			to[7] = copy[0];
			for(int i = 0; i < 7; i++) {
				to[i] = copy[i+1];
			}
		}
	}

}
