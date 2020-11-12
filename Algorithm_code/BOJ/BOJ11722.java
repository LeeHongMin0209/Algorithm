package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11722 {
	static int lower_idx(int target, int len) {
		int st = 0;
		int en = len;
		while(st < en) {
			int mid = (st+en) / 2;
			if(SIS.get(mid) >= target) en = mid;
			else st = mid + 1;
		}
		return st;
	}

	static ArrayList<Integer> SIS = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		SIS.add(arr[n-1]);
		for(int i = n-2; i >= 0; i--) {
			int num = arr[i];
			int idx = lower_idx(num, SIS.size());
			if(idx >= SIS.size()) SIS.add(num);
			else SIS.set(idx, num);
		}
		System.out.println(SIS.size());
	}

}
