package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18808 {
	static int n,m,k,r,c,ans;
	static int[][] map = new int[42][42];
	static int[][] sticker = new int[12][12];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < k ; i++) {
			
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			sticker = new int[12][12];
			for(int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());
				for(int z = 0; z < c; z++) {
					sticker[j][z] = Integer.parseInt(st.nextToken());
				}
			}
			boolean check = false;
			loop : for(int j = 0; j < 4; j++) {
				for(int x = 0; x <= n-r; x++) {
					for(int y = 0; y <= m-c; y++) {
						if(isPossible(x, y)) {
							check = true;
							break loop;
						}
					}
				}
				rotate();
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) ans++;
			}
		}
		System.out.println(ans);
	}
	static boolean isPossible(int x, int y) {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i+x][j+y] == 1 && sticker[i][j] == 1) return false;
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(sticker[i][j] == 1) {
					map[i+x][j+y] = 1;
				}
			}
		}
		return true;
	}
	
	
	static void rotate() {
		//sticker배열이 회전 중 변환되는걸 방지하기위해 temp배열 생성
		int[][] temp = new int[12][12];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				temp[i][j] = sticker[i][j];
			}
		}
		
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				sticker[i][j] = temp[r-1-j][i];
			}
		}
		int t = c;
		c = r;
		r = t;
	}
}
