package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10989 {
	static int[] cnt = new int[2000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];	
		for(int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			arr[i] = val;
			cnt[val+1000000]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 2000000; i++) {
			while(cnt[i]-- > 0) {
				sb.append(i-1000000 + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
