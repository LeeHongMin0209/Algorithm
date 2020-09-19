package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		System.out.println(mod(a, b, c));
	}
	static long mod(long a, long b, long c) {
		if(b == 0) return 1;
		long val = mod(a, b/2, c);
		val = val * val % c;
		if(b%2 == 0) return val;
		return val*a%c;
	}
}
