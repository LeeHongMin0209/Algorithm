package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9663 {
	static int n, ans;
	static int[][] map = new int[15][15];
	static boolean[] visited1 = new boolean[15];
	static boolean[] visited2 = new boolean[30];
	static boolean[] visited3 = new boolean[30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		back(0);
		System.out.println(ans);
	}
	static void back(int k) {
		if(k == n) {
			ans++;
			return;
		}
		for(int i = 0; i < n; i++) {
			if(visited1[i] || visited2[k+i] || visited3[k-i+n-1]) {
				continue;
			}
			visited1[i] = true;
			visited2[k+i] = true;
			visited3[k-i+n-1] = true;
			back(k+1);
			visited1[i] = false;
			visited2[k+i] = false;
			visited3[k-i+n-1] = false;
		}
	}
}
