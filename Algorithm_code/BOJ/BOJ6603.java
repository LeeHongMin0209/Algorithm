package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
	static int n;
	static int[] arr,temp;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			arr = new int[n];
			temp = new int[n];
			visited = new boolean[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			func(0);
			System.out.println(sb.toString());
			sb.delete(0,sb.length());
		}		
	}
	static void func(int k) {
		if(k == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(temp[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				temp[k] = arr[i];
				visited[i] = true;
				if(k == 0) func(k+1);
				if(k > 0 && temp[k-1] < arr[i]) func(k+1);
				visited[i] = false;								
			}
		}
	}
}
