package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
	static int[] arr = new int[10000000];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		for(int i = 4; i <= n; i++) {
			if(i % 2 == 0) arr[i] = Math.min(arr[i / 2] + 1, arr[i-1] + 1);
			if(i % 3 == 0) arr[i] = Math.min(arr[i / 3] + 1, arr[i-1] + 1);
			if(i%2 != 0 && i%3 != 0) arr[i] = arr[i-1] + 1;
			
		}
		System.out.println(arr[n]);
	}

}
