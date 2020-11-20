package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1744 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int m = 0;
		int k = 0;
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] <= 0) m++;
			else k++;
		}
		
		Arrays.sort(arr);
		long ans = 0;
		int[] plus = new int[k];
		int[] ma = new int[m];
		int pIdx = 0;
		int mIdx = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] <= 0) {
				ma[mIdx] = arr[i];
				mIdx++;
			} else {
				plus[pIdx] = arr[i];
				pIdx++;
			}
		}
		//마이너스 계산
		if(m % 2 == 0) {
			for(int i = 0; i < m - 1 ; i+=2) {
				ans += ma[i]*ma[i+1];
			}
		} else {
			for(int i = 0; i < m-1; i+=2) {
				ans += ma[i]*ma[i+1];
			}
			ans += ma[ma.length-1];
		}
		//플러스 계산
		if(k % 2 == 0) {
			for(int i = k-1; i > 0; i-=2) {
				
				ans += Math.max(plus[i]*plus[i-1],plus[i]+plus[i-1]);
			}
		} else {
			for(int i = k-1; i > 1; i-=2) {
				ans += Math.max(plus[i]*plus[i-1],plus[i]+plus[i-1]);
			}
			ans += plus[0];
		}
		
		System.out.println(ans);
	}

}
