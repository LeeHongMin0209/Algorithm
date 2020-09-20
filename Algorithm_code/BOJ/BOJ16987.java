package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {
	static int n, ans;
	static int[][] arr;
	static boolean[] vistied;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		vistied = new boolean[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		func(0);
		System.out.println(ans);
	}
	static void func(int now) {
		if(now == n) {
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				if(arr[i][0] <= 0) cnt++;
			}
			if(ans < cnt) ans = cnt;
			return;
		}
		if(arr[now][0] <= 0) {
			func(now+1);
		} else {
			boolean f = false;
			for(int i = 0; i < n; i++) {
				if(i == now || arr[i][0] <= 0) continue;
				f = true;
				arr[i][0] -= arr[now][1];
				arr[now][0] -= arr[i][1];
				func(now + 1);
				arr[i][0] += arr[now][1];
				arr[now][0] += arr[i][1];
			}
			if(!f) func(now+1);
		}
	}

}
