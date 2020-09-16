package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		long sum = 0;
		int left = 0, right = 0;
		while(true) {
			if(sum >= m) {
				sum -= arr[left++];
			} else if(right == n) {
				break;
			} else {
				sum += arr[right++];
			}
			if(sum == m) {
				count++;
			}
		}
		System.out.println(count);
	}
}
