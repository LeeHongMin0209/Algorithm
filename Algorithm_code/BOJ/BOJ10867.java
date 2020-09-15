package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10867 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[2001];
		for(int i = 0; i < n; i++) {
			int val = Integer.parseInt(st.nextToken());
			arr[val + 1000]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= 2000; i++) {
			if(arr[i] >= 1) sb.append(i - 1000 + " ");
		}
		System.out.println(sb.toString());
	}

}
