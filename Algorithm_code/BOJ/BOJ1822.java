package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1822 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int[] arr1 = new int[n];
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j < m; j++) {
			arr2[j] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr2);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int check = Arrays.binarySearch(arr2, arr1[i]);
			if(check < 0) {
				cnt++;
				sb.append(arr1[i] + " ");
			}
		}
		if(cnt > 0) {
			System.out.println(cnt);
			System.out.println(sb.toString());			
		} else System.out.println(cnt);
	}

}
