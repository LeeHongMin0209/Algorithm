package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11728 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[n];
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr3 = new int[arr1.length + arr2.length];
		int idx0 = 0;
		int idx1 = 0;
		int idx2 = 0;
		
		while(idx1 < arr1.length && idx2 < arr2.length) {
			if(arr1[idx1] < arr2[idx2]) arr3[idx0++] = arr1[idx1++];
			else arr3[idx0++] = arr2[idx2++];
		}
		
		while(idx1 < arr1.length) {
			arr3[idx0++] = arr1[idx1++];
		}
		while(idx2 < arr2.length) {
			arr3[idx0++] = arr2[idx2++];
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < arr3.length; i++) {
			sb.append(arr3[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
