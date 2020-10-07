package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ11780 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[105][105];
		int[][] nxt = new int[105][105];
		for(int i = 1; i <= n; i++) {
			Arrays.fill(map[i], 10000001);			
		}
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(map[a][b], c);
			nxt[a][b] = b;
		}
		for(int i = 1; i <= n ; i++) map[i][i] = 0;
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						nxt[i][j] = nxt[i][k];
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == 10000001) map[i][j] = 0;
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == 0 || map[i][j] == 10000001) {
					System.out.println(0);
					continue;
				}
				Vector<Integer> vec = new Vector<>();
				int st = i;
				while(st != j) {
					vec.add(st);
					st = nxt[st][j];
				
				}
				vec.add(j);
				System.out.print(vec.size() + " ");
				for(int x : vec) System.out.print(x  + " ");
				System.out.println();
			}
		}
	}

}
