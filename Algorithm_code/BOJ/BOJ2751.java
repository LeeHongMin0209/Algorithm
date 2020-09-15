package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2751 {
	static int[] arr = new int[1000001];
	static int[] tmp = new int[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			arr[i] = val;
		}
		merge_sort(0, n);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb.toString());
	}
	static void merge(int st, int en) {
		int mid = (st+en) / 2;
		int idx0 = st;
		int idx1 = st;
		int idx2 = mid;
		
		while(idx1 < mid && idx2 < en) {
			if(arr[idx1] < arr[idx2]) tmp[idx0++] = arr[idx1++];				
			else tmp[idx0++] = arr[idx2++];
		}
		
		while(idx1 < mid) {
			tmp[idx0++] = arr[idx1++];
		}
		while(idx2 < en) {
			tmp[idx0++] = arr[idx2++];
		}
		for(int i = st; i < en; i++) {
			arr[i] = tmp[i];
		}
	}
	static void merge_sort(int st, int en) {
		if(en - st == 1) return;
		if(en - st == 2) {
			if(arr[st] > arr[st+1]) {
				int tmp = arr[st];
				arr[st] = arr[st+1];
				arr[st+1] = tmp;
			}
			return;
		}
		int mid = (st+en) / 2;
		merge_sort(st, mid);
		merge_sort(mid, en);
		merge(st, en);
	}
	
}
