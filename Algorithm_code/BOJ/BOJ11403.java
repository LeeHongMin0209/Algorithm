package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11403 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        //최단거리 나타내는 배열
		int[][] map = new int[105][105];
        //경로 나타내는 배열
		int[][] nxt = new int[105][105];
		for(int i = 1; i <= n; i++) {
			Arrays.fill(map[i], 10000001);			
		}
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) map[i][j] = num;
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
        //최단거리 출력
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == 10000001) System.out.print(0 + " ");
				else System.out.print(1 +" ");
			}
			System.out.println();
		}
	}

}
