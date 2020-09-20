package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
	static int n,s,cnt;
	static int[] arr = new int[20];
	static boolean[] visited = new boolean[20];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		func(0,0);
		if(s == 0 ) cnt--;
		System.out.println(cnt);
	}
	static void func(int sum, int k) {
		if(k == n) {
			if(sum == s) cnt++;			
			return;		
		}
		func(sum + arr[k], k + 1);
		func(sum, k + 1);
	}
}
