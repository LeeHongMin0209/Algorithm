package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
	static int n,m;
	static int[] arr = new int[10];
	static boolean[] visited = new boolean[10];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		func(0);	
		System.out.println(sb.toString());
	}
	static void func(int k) {
		if(k == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");		
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= n; i++) {
			arr[k] = i;
			func(k+1);
			
		}
		
	}
}
