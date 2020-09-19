package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
	static int n,m;
	static int[] arr = new int[10];
	static boolean[] visited = new boolean[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		func(0);
	}
	static void func(int k) {
		if(k == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				arr[k] = i;
				if(k > 0 && arr[k] > arr[k-1]) {
					visited[i] = true;
					func(k+1);
					visited[i] = false;
				} else if(k == 0) {
					visited[i] = true;
					func(k+1);
					visited[i] = false;
				}
			}
		}
	}
}
