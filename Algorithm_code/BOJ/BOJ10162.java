package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10162 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = {300,60,10};
		int[] ans = new int[3];
		for(int i = 0; i < 3; i++){
			if(n >= arr[i]) {
				ans[i] = n / arr[i];
				n %= arr[i];
			}
		}
		if(n != 0) System.out.println(-1);
		else {
			for(int i = 0; i < 3; i++) {
				System.out.print(ans[i] + " ");
			}
		}
	}

}
