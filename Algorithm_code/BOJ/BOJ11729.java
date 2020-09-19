package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println((int)Math.pow(2, n)-1);
		func(1, 3, n);
		System.out.println(sb.toString());
	}
	static void func(int a,int b, int n) {
		if(n == 1) {
			sb.append(a + " " + b + " \n");
			return;
		}
		int c = 6-a-b;
		func(a, c, n-1);
		sb.append(a + " " + b + " \n");
		func(c, b, n-1);
	}
}
