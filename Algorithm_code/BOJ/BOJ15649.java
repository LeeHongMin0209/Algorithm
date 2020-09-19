package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ15649 {
	static int n,m;
	static int[] arr = new int[10];
	static boolean[] visited = new boolean[10];
	public static void main(String[] args) throws IOException{
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
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				arr[k] = i;
				visited[i] = true;
				func(k+1);
				visited[i] = false;
			}
		}
	}
}
