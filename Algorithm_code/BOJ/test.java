package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class test {
	static ArrayList<Integer> LIS = new ArrayList<>();
	static int lower_idx(int target, int len) {
		int st = 0;
		int en = len;
		while(st < en) {
			int mid = (st+en) / 2;
			if(LIS.get(mid) >= target) en = mid;
			else st = mid + 1;
		}
		return st;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1002];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		LIS.add(arr[0]);
		for(int i = 1; i < n; i++) {
			int num = arr[i];
			int idx = lower_idx(num, LIS.size());
			if(idx >= LIS.size()) {
				LIS.add(num);
			} else LIS.set(idx, num);
			
		}
		System.out.println(LIS.size());
	}
}
