package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2750 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];	
		for(int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			arr[i] = val;
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb.toString());
	}
}
