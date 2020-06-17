package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2437 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] coo = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			coo[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coo);
		int sum = 0;
		for(int i = 0; i < n; i++) {
			if(coo[i] <= sum + 1) {
				sum += coo[i];
			}
		}
		System.out.println(sum+1);
	}

}
