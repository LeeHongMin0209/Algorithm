package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int target = arr[i];
			int left = 0, right = n-1;
			while(left < right) {
				int cal = arr[left] + arr[right];
				if(cal < target) {
					left++;
				} else if(cal > target) {
					right--;
				} else {
					if(i != left && i != right) {
						cnt++;
						break;
					}
					if(left == i) left++;
					if(right == i) right--;
				}				
			}
		}
		System.out.println(cnt);
	}

}
