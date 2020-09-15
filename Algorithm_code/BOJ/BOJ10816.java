package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {
	static int[] arr;
	static int lower_idx(int target, int len) {
		int st = 0;
		int en = len;
		while(st < en) {
			int mid = (st+en) / 2;
			if(arr[mid] >= target) en = mid;
			else st = mid + 1;
		}
		return st;
	}
	static int upper_idx(int target, int len) {
		int st = 0;
		int en = len;
		while(st < en) {
			int mid = (st+en) / 2;
			if(arr[mid] > target) en = mid;
			else st = mid + 1;
		}
		return st;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		int len = arr.length;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			int lower = lower_idx(num, len);
			int upper = upper_idx(num, len);
			System.out.print(upper-lower  + " ");
		}
	}

}
