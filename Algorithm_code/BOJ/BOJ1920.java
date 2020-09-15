package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
	static int BinarySearch(int target, int len, int[] arr) {
		int st = 0;
		int en = len - 1;
		while(st <= en) {
			int mid = (st+en) / 2;
			if(arr[mid] < target) {
				st = mid + 1;
			} else if(arr[mid] > target) {
				en = mid - 1;
			} else {
				return 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			int check = BinarySearch(num, arr.length, arr);
			if(check == 1) System.out.println(1);
			else System.out.println(0);
		}
	}
}
